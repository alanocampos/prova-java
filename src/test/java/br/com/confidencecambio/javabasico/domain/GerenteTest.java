package br.com.confidencecambio.javabasico.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.confidencecambio.javabasico.model.Gerente;

public class GerenteTest {

    @Test
    public void deveRetornarPrimeiroNome_QuandoPassarUmNomeValido() {

        var primeiroNome = "João";
        Gerente gerente = new Gerente("João Soares Silva");
        assertEquals(primeiroNome, gerente.getPrimeiroNome());
    }

    @Test
    public void deveRetornarUltimoNome_QuandoPassarUmNomeValido() {

        var ultimoNome = "Soares Silva";
        Gerente gerente = new Gerente("João Soares Silva");
        assertEquals(ultimoNome, gerente.getUltimoNome());
    }

    @Test
    public void deveRetornarNomeMaiusculo_QuandoPassarUmNomeValido() {

        var ultimoNome = "JOÃO SOARES SILVA";
        Gerente gerente = new Gerente("João Soares Silva");
        assertEquals(ultimoNome, gerente.getNomeMaiusculo());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValido() {

        var ultimoNome = "João S. Silva";
        Gerente gerente = new Gerente("João Soares Silva");
        assertEquals(ultimoNome, gerente.getNomeAbreviado());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValidoComVariosNomes() {

        var ultimoNome = "João S. A. Silva";
        Gerente gerente = new Gerente("João Soares Azevedo Silva");
        assertEquals(ultimoNome, gerente.getNomeAbreviado());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValidoComMuitosNomes() {

        var ultimoNome = "João S. A. S. Silva";
        Gerente gerente = new Gerente("João Soares Azevedo Soares Silva");
        assertEquals(ultimoNome, gerente.getNomeAbreviado());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValidoSemNomeParaAbreviar() {

        var ultimoNome = "João  Silva";
        Gerente gerente = new Gerente("João  Silva");
        assertEquals(ultimoNome, gerente.getNomeAbreviado());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarException_QuandoPassarUmNomeComEspacosExtrasNoInicio() {

        new Gerente(" João Soares Silva");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarException_QuandoPassarUmNomeComEspacosExtrasNoFim() {

        new Gerente("João Soares Silva ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarException_QuandoPassarUmNomeVazio() {

        new Gerente("");
    }

    @Test(expected = NullPointerException.class)
    public void deveRetornarException_QuandoPassarUmNomeNulo() {

        new Gerente(null);
    }

}