package com.br.reclameaqui.claim.web.register.service;

import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.base.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClaimRegisterService implements ClaimRegisterServiceInterface {
    @Autowired
    private ClaimRepository repository;

    @Override
    public Claim store(Claim claim) {
        claim.setCreatedAt(new Date());
        return repository.save(claim);
    }

    @Override
    public List<Claim> storeMany(List<Claim> claims) {
        for (Claim claim : claims){
            claim.setCreatedAt(new Date());
        }
        return repository.saveAll(claims);
    }

}
