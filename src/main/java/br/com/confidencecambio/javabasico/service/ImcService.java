package br.com.confidencecambio.javabasico.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import br.com.confidencecambio.javabasico.validator.ImcValidator;

@Service
public class ImcService {

    private final ImcValidator validator;

    public ImcService(ImcValidator validator) {

        this.validator = validator;
    }

    public Double calcula(BigDecimal peso, Integer altura) {

        validator.validate(peso, altura);

        var alturaEmMetros = BigDecimal.valueOf(altura).divide(BigDecimal.valueOf(100));

        var alturaAoQuadrado = alturaEmMetros.multiply(alturaEmMetros);

        var imc = peso.divide(alturaAoQuadrado, 2, RoundingMode.HALF_DOWN);

        return imc.doubleValue();
    }
}
