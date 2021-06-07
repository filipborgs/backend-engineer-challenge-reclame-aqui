package com.br.reclameaqui.claim.web.register.controller;

import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.claim.web.register.service.ClaimRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("register/claims")
public class ClainRegisterController {

    @Autowired
    private ClaimRegisterService service;

    @GetMapping
    public String teste(){
        return "Register Claim service";
    }

    @PostMapping
    public Claim save(@RequestBody Claim claim){
        return service.store(claim);
    }

    @PostMapping("many")
    public List<Claim> saveMany(@RequestBody List<Claim> claims){
        return service.storeMany(claims);
    }
}
