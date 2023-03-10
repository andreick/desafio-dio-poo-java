package com.andreick.poo.domain;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Mentoria extends Conteudo {

    private static final double XP_PADRAO = Conteudo.XP_PADRAO + 20.0;

    private final LocalDate data;

    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        this.data = data;
    }

    @Override
    public Double getXp() {
        return XP_PADRAO;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Mentoria.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("xp=" + getXp())
                .add("titulo='" + getTitulo() + "'")
                .add("descricao='" + getDescricao() + "'")
                .toString();
    }
}
