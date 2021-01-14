package br.com.confidencecambio.javabasico.controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.service.ImcService;

@RestController
@RequestMapping("/imc")
public class ImcController {

    private final ImcService service;

    public ImcController(final ImcService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> calculaImc(@RequestParam(value = "peso") BigDecimal peso, @RequestParam(value = "altura") Integer altura) {

        var retorno = "IMC: " + service.calcula(peso, altura);

        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
