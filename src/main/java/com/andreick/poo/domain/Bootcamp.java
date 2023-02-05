package com.andreick.poo.domain;

import java.time.LocalDate;
import java.util.*;

public class Bootcamp {

    private static final int DURACAO_EM_DIAS = 45;

    private final String nome;
    private final String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(DURACAO_EM_DIAS);
    private final Set<Dev> devsInscritos = new HashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void adicionarConteudo(Conteudo conteudo) {
        conteudos.add(conteudo);
    }

    public void inscrever(Dev dev) {
        devsInscritos.add(dev);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return Collections.unmodifiableSet(devsInscritos);
    }

    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bootcamp.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("descricao='" + descricao + "'")
                .add("dataInicial=" + dataInicial)
                .add("dataFinal=" + dataFinal)
                .toString();
    }
}
