package com.br.reclameaqui.claim.web.consult.controller;

import com.br.reclameaqui.base.exception.NotFoundException;
import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.base.repository.ClaimRepository;
import com.br.reclameaqui.claim.web.consult.service.ClaimConsultService;
import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@WebMvcTest(ClaimConsultController.class)
class ClaimConsultControllerTest {

    @Autowired
    private ClaimConsultController controller;

    @MockBean
    private ClaimConsultService service;

    @MockBean
    private ClaimRepository repository;

    @MockBean
    private Criteria criteria;


    @BeforeEach
    public void setup() {
        standaloneSetup(this.controller);
    }

    @Test
    void mustReturnArray_whenGetAllClaims() {
        Mockito.when(this.service.all()).thenReturn(new ArrayList<Claim>());
        given().accept(ContentType.JSON).when()
                .get("/consult/claims/all").then().statusCode(HttpStatus.OK.value());
    }

    @Test
    void mustReturnJson_whenGetAClaim() throws NotFoundException {
        Claim claim = new Claim();
        claim.setId("validId");
        claim.setTitle("Claim'");
        claim.setDescription("Claim description");
        Mockito.when(this.service.findById("validId")).thenReturn(claim);

        given().accept(ContentType.JSON).when()
                .get("/consult/claims/id/{id}", "validId").then().statusCode(HttpStatus.OK.value());
    }

    @Test
    void mustReturnNotFound_whenGetAClaimWhichNotExists() throws NotFoundException {
        Mockito.when(this.service.findById("invlaidId")).thenThrow(new NotFoundException("Reclamaç�o"));

        given().accept(ContentType.JSON).when()
                .get("/consult/claims/id/{id}", "invlaidId").then().statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void mustReturnArray_whenGetClaimsByUf() {
        Mockito.when(this.service.all()).thenReturn(new ArrayList<Claim>());
        given().accept(ContentType.JSON).when()
                .get("/consult/claims/uf/{uf}", "validUf").then().statusCode(HttpStatus.OK.value());
    }

    @Test
    void mustReturnArray_whenSearchClaims() {
        Mockito.when(this.service.search("Pc não chegou")).thenReturn(this.service);
        Mockito.when(this.service.addCompany("Magazine")).thenReturn(this.service);
        Mockito.when(this.service.addCity("Feira de Santana")).thenReturn(this.service);
        Mockito.when(this.service.addUf("BA")).thenReturn(this.service);
        Mockito.when(this.service.addStreet("Rua A")).thenReturn(this.service);
        Mockito.when(this.service.addConsumer("Filipe")).thenReturn(this.service);
        Mockito.when(this.service.makeSearch()).thenReturn(new ArrayList<Claim>());

        given().accept(ContentType.JSON).queryParam("search", "Pc não chegou")
                .queryParam("street", "Rua A").queryParam("company", "Magazine")
                .queryParam("city", "Feira de Santana").queryParam("consumer", "Filipe")
                .queryParam("uf", "BA").when()
                .get("/consult/claims/search").then().statusCode(HttpStatus.OK.value());
    }
}
