package com.andreick.poo.domain;

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
}
