package com.andreick.poo.domain;

import java.util.StringJoiner;

public class Curso extends Conteudo {

    private int cargaHoraria;

    public Curso(String titulo, String descricao) {
        super(titulo, descricao);
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Curso.class.getSimpleName() + "[", "]")
                .add("cargaHoraria=" + cargaHoraria)
                .add("titulo='" + getTitulo() + "'")
                .add("descricao='" + getDescricao() + "'")
                .toString();
    }
}
