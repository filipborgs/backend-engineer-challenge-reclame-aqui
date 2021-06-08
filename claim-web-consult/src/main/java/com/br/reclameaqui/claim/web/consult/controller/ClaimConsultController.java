package com.br.reclameaqui.claim.web.consult.controller;

import com.br.reclameaqui.base.exception.NotFoundException;
import com.br.reclameaqui.base.exception.TreatedExcetpion;
import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.claim.web.consult.service.ClaimConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Claim> get(@PathVariable String id) throws TreatedExcetpion {
        try {
            Claim claim = service.findById(id);
            return ResponseEntity.ok(claim);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("uf/{uf}")
    public ResponseEntity<List<Claim>> getByUf(@PathVariable String uf) {
        return ResponseEntity.ok(service.findByUf(uf));
    }

}
