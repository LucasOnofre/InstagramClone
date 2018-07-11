package com.parse.starter.util;

import java.util.HashMap;

public class ParseErros {


    private HashMap<Integer,String> erros;


    public ParseErros() {
        this.erros = new HashMap<>();
        this.erros.put(-1, "Erro inesperado!");
        this.erros.put(201,"Senha não foi preenchida!");
        this.erros.put(202,"Usuário já existe, escolha outro usuário");
    }

    public String getError(int codErro){
        return this.erros.get(codErro);
    }
}
