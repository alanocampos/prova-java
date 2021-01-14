package br.com.confidencecambio.javabasico.service;

import java.util.Optional;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private static final String valorPadrao = "Mundo";

    public String retornaValorValido(@Nullable String nome) {

        return Optional.ofNullable(nome).orElse(valorPadrao);
    }
}
