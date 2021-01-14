package br.com.confidencecambio.javabasico.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.confidencecambio.javabasico.model.Cliente;

public class ClientTest {

    @Test
    public void deveRetornarPrimeiroNome_QuandoPassarUmNomeValido() {

        var primeiroNome = "João";
        Cliente cliente = new Cliente("João Soares Silva");
        assertEquals(primeiroNome, cliente.getPrimeiroNome());
    }

    @Test
    public void deveRetornarUltimoNome_QuandoPassarUmNomeValido() {

        var ultimoNome = "Soares Silva";
        Cliente cliente = new Cliente("João Soares Silva");
        assertEquals(ultimoNome, cliente.getUltimoNome());
    }

    @Test
    public void deveRetornarNomeMaiusculo_QuandoPassarUmNomeValido() {

        var ultimoNome = "JOÃO SOARES SILVA";
        Cliente cliente = new Cliente("João Soares Silva");
        assertEquals(ultimoNome, cliente.getNomeMaiusculo());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValido() {

        var ultimoNome = "João S. Silva";
        Cliente cliente = new Cliente("João Soares Silva");
        assertEquals(ultimoNome, cliente.getNomeAbreviado());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValidoComVariosNomes() {

        var ultimoNome = "João S. A. Silva";
        Cliente cliente = new Cliente("João Soares Azevedo Silva");
        assertEquals(ultimoNome, cliente.getNomeAbreviado());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValidoComMuitosNomes() {

        var ultimoNome = "João S. A. S. Silva";
        Cliente cliente = new Cliente("João Soares Azevedo Soares Silva");
        assertEquals(ultimoNome, cliente.getNomeAbreviado());
    }

    @Test
    public void deveRetornarNomeAbreviado_QuandoPassarUmNomeValidoSemNomeParaAbreviar() {

        var ultimoNome = "João  Silva";
        Cliente cliente = new Cliente("João  Silva");
        assertEquals(ultimoNome, cliente.getNomeAbreviado());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarException_QuandoPassarUmNomeComEspacosExtrasNoInicio() {

        new Cliente(" João Soares Silva");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarException_QuandoPassarUmNomeComEspacosExtrasNoFim() {

        new Cliente("João Soares Silva ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarException_QuandoPassarUmNomeVazio() {

        new Cliente("");
    }

    @Test(expected = NullPointerException.class)
    public void deveRetornarException_QuandoPassarUmNomeNulo() {

        new Cliente(null);
    }

}