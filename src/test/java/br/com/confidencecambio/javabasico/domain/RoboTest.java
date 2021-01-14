package br.com.confidencecambio.javabasico.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.confidencecambio.javabasico.model.Gerente;
import br.com.confidencecambio.javabasico.model.Robo;

public class RoboTest {

    @Test
    public void deveRetornarPrimeiroNome_QuandoPassarUmNomeValido() {

        var primeiroNome = "João";
        Robo robo = new Robo("João Soares Silva");
        assertEquals(primeiroNome, robo.getPrimeiroNome());
    }

    @Test
    public void deveRetornarUltimoNome_QuandoPassarUmNomeValido() {

        var ultimoNome = "Soares Silva";
        Robo robo = new Robo("João Soares Silva");
        assertEquals(ultimoNome, robo.getUltimoNome());
    }

    @Test
    public void deveRetornarNomeMaiusculo_QuandoPassarUmNomeValido() {

        var ultimoNome = "JOÃO SOARES SILVA";
        Robo robo = new Robo("João Soares Silva");
        assertEquals(ultimoNome, robo.getNomeMaiusculo());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValido() {

        var ultimoNome = "João S. Silva";
        Robo robo = new Robo("João Soares Silva");
        assertEquals(ultimoNome, robo.getNomeAbreviado());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValidoComVariosNomes() {

        var ultimoNome = "João S. A. Silva";
        Robo robo = new Robo("João Soares Azevedo Silva");
        assertEquals(ultimoNome, robo.getNomeAbreviado());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValidoComMuitosNomes() {

        var ultimoNome = "João S. A. S. Silva";
        Robo robo = new Robo("João Soares Azevedo Soares Silva");
        assertEquals(ultimoNome, robo.getNomeAbreviado());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValidoSemNomeParaAbreviar() {

        var ultimoNome = "João  Silva";
        Robo robo = new Robo("João  Silva");
        assertEquals(ultimoNome, robo.getNomeAbreviado());
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