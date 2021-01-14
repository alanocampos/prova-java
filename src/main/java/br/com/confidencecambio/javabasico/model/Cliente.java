package br.com.confidencecambio.javabasico.model;

import lombok.NonNull;

public class Cliente extends AbstractDomain {

    public Cliente(@NonNull String nome) {

        super(nome);
    }
}
