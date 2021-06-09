package com.br.reclameaqui.claim.web.register.controller;

import com.br.reclameaqui.base.model.Address;
import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.base.model.Company;
import com.br.reclameaqui.base.model.Consumer;
import com.br.reclameaqui.base.repository.ClaimRepository;
import com.br.reclameaqui.claim.web.register.service.ClaimRegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(ClaimRegisterController.class)
class ClaimRegisterControllerTest {

    @Autowired
    private ClaimRegisterController controller;

    @MockBean
    private ClaimRegisterService service;

    @MockBean
    private ClaimRepository repository;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.controller);
    }

    @Test
    void mustReturnId_whenCreateAClaim() {
        Claim claim = new Claim();
        claim.setTitle("Created Claim'");
        claim.setDescription("Claim description");
        claim.setConsumer(new Consumer("Filipe"));
        claim.setAddress(new Address("Feira de Santana", "BA"));
        claim.setCompany(new Company("Empresa teste"));
        claim.setId("validId");
        Mockito.when(this.service.store(Mockito.any(Claim.class))).thenReturn(claim);

        given().contentType(ContentType.JSON).body(asJsonString(claim)).accept(ContentType.JSON).when()
                .post("/register/claims", claim).then().statusCode(HttpStatus.CREATED.value());
    }

    @Test
    void mustReturnError_whenSendInvalidClaim() {
        Claim claim = new Claim();
        Mockito.when(this.service.store(Mockito.any(Claim.class))).thenReturn(claim);

        //sending invalid empty claim
        given().contentType(ContentType.JSON).body(asJsonString(claim)).accept(ContentType.JSON).when()
                .post("/register/claims", claim).then().statusCode(HttpStatus.BAD_REQUEST.value());

        Mockito.verify(this.service, Mockito.never()).store(Mockito.any(Claim.class));
    }

    @Test
    void mustReturnArrayOfIds_whenCreateManyClaims() {
        Claim claim = new Claim();
        claim.setTitle("Created Claim'");
        claim.setDescription("Claim description");
        claim.setConsumer(new Consumer("Filipe"));
        claim.setAddress(new Address("Feira de Santana", "BA"));
        claim.setCompany(new Company("Empresa teste"));
        claim.setId("validId");

        Claim claim2 = new Claim();
        claim2.setTitle("Created Claim 2'");
        claim2.setDescription("Claim description 2");
        claim2.setConsumer(new Consumer("Patricia"));
        claim2.setAddress(new Address("Feira de Santana", "BA"));
        claim2.setCompany(new Company("Empresa teste"));
        claim2.setId("validId2");
        List<Claim> list = new ArrayList<>();
        list.add(claim);
        list.add(claim2);

        Mockito.when(this.service.storeMany(Mockito.any(List.class))).thenReturn(list);

        given().contentType(ContentType.JSON).body(asJsonString(list)).accept(ContentType.JSON).when()
                .post("/register/claims/many", claim).then().statusCode(HttpStatus.CREATED.value());
    }

    @Test
    void mustReturnError_whenSendEmptyListOfClaims() {
        Mockito.when(this.service.store(null)).thenReturn(null);

        //sending invalid empty claim
        given().contentType(ContentType.JSON).accept(ContentType.JSON).when()
                .post("/register/claims").then().statusCode(HttpStatus.BAD_REQUEST.value());

        Mockito.verify(this.service, Mockito.never()).store(null);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
