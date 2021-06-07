package com.br.reclameaqui.claim.web.consult.controller;

import com.br.reclameaqui.base.exception.TreatedExcetpion;
import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.claim.web.consult.service.ClaimConsultService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String teste(){
        return "Consult claim service";
    }

    @GetMapping("all")
    public List<Claim> all() {
        return service.all();
    }

    @GetMapping("id/{id}")
    public Claim get(@PathVariable String id) throws TreatedExcetpion {
        return service.findById(id);
    }

    @GetMapping("uf")
    public List<Claim> getByUf(){
        return service.findByUf("MG");
    }
}
