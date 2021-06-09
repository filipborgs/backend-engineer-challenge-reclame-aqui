package com.br.reclameaqui.claim.web.consult.controller;

import com.br.reclameaqui.base.exception.NotFoundException;
import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.claim.web.consult.service.ClaimConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consult/claims")
public class ClaimConsultController {

    @Autowired
    private ClaimConsultService service;

    @GetMapping
    public String teste() {
        return "Consult claim service";
    }

    @GetMapping("all")
    public ResponseEntity<List<Claim>> all() {
        return ResponseEntity.ok(service.all());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Claim> get(@PathVariable String id) {
        try {
            Claim claim = service.findById(id);
            return ResponseEntity.ok(claim);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("search")
    public ResponseEntity<List<Claim>> search(@RequestParam(value = "search", required = false) String search,
                                              @RequestParam(value = "company", required = false) String company,
                                              @RequestParam(value = "city", required = false) String city,
                                              @RequestParam(value = "street", required = false) String street,
                                              @RequestParam(value = "uf", required = false) String uf,
                                              @RequestParam(value = "consumer", required = false) String consumer) {
        List<Claim> list = service.search(search).addCompany(company)
                .addCity(city).addUf(uf).addStreet(street).addConsumer(consumer)
                .makeSearch();
        return ResponseEntity.ok(list);
    }

    @GetMapping("uf/{uf}")
    public ResponseEntity<List<Claim>> getByUf(@PathVariable String uf) {
        return ResponseEntity.ok(service.findByUf(uf));
    }
}
