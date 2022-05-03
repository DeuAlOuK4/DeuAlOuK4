package br.TrabalhoFinal.BackEnd.BanckEnd.Util;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BackEndException extends ResponseStatusException {

    public BackEndException(String mensagem){
        super(HttpStatus.INTERNAL_SERVER_ERROR, mensagem);
    }
}
