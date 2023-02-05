package com.andreick.poo.domain;

import java.util.Objects;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10.0;

    private final String titulo;
    private final String descricao;

    public Conteudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public double calcularXp() {
        return XP_PADRAO;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conteudo conteudo = (Conteudo) o;
        return titulo.equals(conteudo.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
