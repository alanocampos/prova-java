package br.com.confidencecambio.javabasico.model;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDomain {

    @NotBlank
    private String nome;

    public AbstractDomain(@NonNull String nome) {

        validate(nome);
        this.nome = nome;
    }

    public String getPrimeiroNome() {

        String nome;

        int pos = StringUtils.ordinalIndexOf(this.nome, " ", 1);

        if (pos > 0) {
            nome = this.nome.substring(0, pos);
        } else {
            nome = this.nome;
        }

        return nome;
    }

    public String getUltimoNome() {

        String nome;

        int pos = StringUtils.ordinalIndexOf(this.nome, " ", 1);

        if (pos > 0) {
            nome = this.nome.substring(pos + 1);
        } else {
            nome = this.nome;
        }

        return nome;
    }

    public String getNomeMaiusculo() {

        return this.nome.toUpperCase();
    }

    public String getNomeAbreviado() {

        String nome;

        int count = StringUtils.countMatches(this.nome, " " );

        if (count >= 2) {

            String nomeAbreviado = this.nome;

            for (int i = 2; i <= count; i++) {

                int inicio = StringUtils.ordinalIndexOf(this.nome, " ", i -1);
                int fim = StringUtils.ordinalIndexOf(this.nome, " ", i);

                String nomeASerSubstituido = this.nome.substring(inicio + 1, fim);

                if (!nomeASerSubstituido.isBlank()) {

                    nomeAbreviado = nomeAbreviado.replaceAll(nomeASerSubstituido, nomeASerSubstituido.charAt(0) + ".");
                }

            }

            nome = nomeAbreviado;

        } else {
            nome = this.nome;
        }

        return nome;
    }

    private void validate(String nome) {

        if (StringUtils.isBlank(nome)) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (startsWithSpace(nome)) {
            throw new IllegalArgumentException("Nome não pode conter espaços extras no início");
        }

        if (endsWithSpace(nome)) {
            throw new IllegalArgumentException("Nome não pode conter espaços extras no fim");
        }
    }

    private boolean startsWithSpace(String nome) {

        return Character.isWhitespace(nome.charAt(0));
    }

    private boolean endsWithSpace(String nome) {

        return Character.isWhitespace(nome.charAt(nome.length() - 1));
    }
}
