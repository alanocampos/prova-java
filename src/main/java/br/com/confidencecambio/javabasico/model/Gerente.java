package br.com.confidencecambio.javabasico.model;

import lombok.NonNull;

public class Gerente extends AbstractDomain {

    public Gerente(@NonNull String nome) {

        super(nome);
    }
}
