package com.br.reclameaqui.claim.web.consult.service;

import com.br.reclameaqui.base.exception.NotFoundException;
import com.br.reclameaqui.base.model.Claim;
import com.br.reclameaqui.base.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimConsultService implements ClaimConsultServiceInterface {

    @Autowired
    private ClaimRepository repository;

    @Override
    public List<Claim> all() {
        return repository.findAll();
    }

    @Override
    public Claim findById(String id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Reclamação"));
    }

    @Override
    public List<Claim> findByUf(String uf){
        return repository.findByUf(uf.toUpperCase());
    }

}
