package br.com.confidencecambio.javabasico.validator;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.confidencecambio.javabasico.exception.NegocioException;

@Component
public class ImcValidator {

    public void validate(BigDecimal peso, Integer altura) {

        Optional.ofNullable(peso).orElseThrow(() -> new NegocioException("O parâmetro de URL peso não pode ser nulo"));

        Optional.ofNullable(altura).orElseThrow(() -> new NegocioException("O parâmetro de URL altura não pode ser nulo"));
    }

}
