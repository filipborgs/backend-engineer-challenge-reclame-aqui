package com.br.reclameaqui.claim.web.consult.service;

import com.br.reclameaqui.base.exception.NotFoundException;
import com.br.reclameaqui.base.model.Claim;

import java.util.List;

public interface ClaimConsultServiceInterface {
    List<Claim> all();

    Claim findById(String id) throws NotFoundException;

    List<Claim> findByUf(String uf);
}
