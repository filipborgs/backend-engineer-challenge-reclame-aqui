package com.br.reclameaqui.claim.web.register.controller;

import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.claim.web.register.service.ClaimRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("register/claims")
public class ClaimRegisterController {

    @Autowired
    private ClaimRegisterService service;

    @GetMapping
    public String teste() {
        return "Register Claim service";
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid Claim claim) {
        if (claim == null) {
            ResponseEntity.badRequest().build();
        }
        claim = service.store(claim);
        return ResponseEntity.created(null).body(claim.getId());
    }

    @PostMapping("many")
    public ResponseEntity<List<String>> saveMany(@RequestBody List<Claim> claims) {
        if (claims == null || claims.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        List<String> inserteds = service.storeMany(claims).stream().map(Claim::getId).collect(Collectors.toList());
        return ResponseEntity.created(null).body(inserteds);
    }
}
