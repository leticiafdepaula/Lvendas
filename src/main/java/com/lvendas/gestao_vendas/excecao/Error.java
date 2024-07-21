package com.lvendas.gestao_vendas.excecao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

    private String msgUsuario;
    private String msgDesenvolvedor;

    public Error(String msgUsuario, String msgDesenvolvedor) {
        this.msgUsuario = msgUsuario;
    }
}
