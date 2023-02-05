package com.andreick.poo.domain;

import java.util.StringJoiner;

public class Curso extends Conteudo {

    private final int cargaHoraria;

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public Double getXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Curso.class.getSimpleName() + "[", "]")
                .add("cargaHoraria=" + cargaHoraria)
                .add("xp=" + getXp())
                .add("titulo='" + getTitulo() + "'")
                .add("descricao='" + getDescricao() + "'")
                .toString();
    }
}
