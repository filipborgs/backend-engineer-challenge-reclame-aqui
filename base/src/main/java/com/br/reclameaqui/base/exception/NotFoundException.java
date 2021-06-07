package com.br.reclameaqui.base.exception;

//import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends TreatedExcetpion {

    public NotFoundException(String desc) {
        super(StringUtils.capitalize(desc) + " não encontrado");
    }

}
