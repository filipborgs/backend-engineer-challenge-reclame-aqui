package com.br.reclameaqui.claim.web.register.service;

import com.br.reclameaqui.base.model.Claim;

import java.util.List;

public interface ClaimRegisterServiceInterface {

    Claim store(Claim claim);

    List<Claim> storeMany(List<Claim> claims);
}
