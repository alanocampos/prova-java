package br.com.confidencecambio.javabasico.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.confidencecambio.javabasico.exception.NegocioException;
import br.com.confidencecambio.javabasico.validator.ImcValidator;

@SpringBootTest
public class ImcServiceTest {

    private ImcService service;

    private ImcValidator validator;

    @Before
    public void init() {

        validator = new ImcValidator();
        service = new ImcService(validator);
    }

    @Test
    public void deveRetornarOImc_QuandoPassarDadosValidos() {

        Double imc = 22.86;
        Double valorValido = service.calcula(BigDecimal.valueOf(70), 175);
        assertEquals(imc, valorValido);
    }

    @Test(expected = NegocioException.class)
    public void deveRetornarException_QuandoPassarPesoNulo() {

        service.calcula(null, 175);
    }

    @Test(expected = NegocioException.class)
    public void deveRetornarException_QuandoPassarAlturaNulo() {

        service.calcula(BigDecimal.valueOf(70), null);
    }

}