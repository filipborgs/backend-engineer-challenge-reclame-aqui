package com.br.reclameaqui.claim.web.consult.controller;

import com.br.reclameaqui.base.exception.NotFoundException;
import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.base.repository.ClaimRepository;
import com.br.reclameaqui.claim.web.consult.service.ClaimConsultService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@WebMvcTest(ClaimConsultController.class)
public class ClaimConsultControllerTest {

    @Autowired
    private ClaimConsultController controller;

    @MockBean
    private ClaimConsultService service;

    @MockBean
    private ClaimRepository repository;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(this.controller);
    }

    @Test
    public void mustReturnArray_whenGetAllClaims() {
        Mockito.when(this.service.all()).thenReturn(new ArrayList<Claim>());
        RestAssuredMockMvc.given().accept(ContentType.JSON).when()
                .get("/consult/claims/all").then().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void mustReturnJson_whenGetAClaim() throws NotFoundException {
        Claim claim = new Claim();
        claim.setId("validId");
        claim.setTitle("Claim'");
        claim.setDescription("Claim description");
        Mockito.when(this.service.findById("validId")).thenReturn(claim);

        RestAssuredMockMvc.given().accept(ContentType.JSON).when()
                .get("/consult/claims/id/{id}", "validId").then().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void mustReturnNotFound_whenGetAClaimWhichNotExists() throws NotFoundException {
        Mockito.when(this.service.findById("invlaidId")).thenThrow(new NotFoundException("Reclamaç�o"));

        RestAssuredMockMvc.given().accept(ContentType.JSON).when()
                .get("/consult/claims/id/{id}", "invlaidId").then().statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void mustReturnArray_whenGetClaimsByUf() {
        Mockito.when(this.service.all()).thenReturn(new ArrayList<Claim>());
        RestAssuredMockMvc.given().accept(ContentType.JSON).when()
                .get("/consult/claims/uf/{uf}", "validUf").then().statusCode(HttpStatus.OK.value());
    }

}
