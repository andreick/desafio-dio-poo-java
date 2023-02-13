package com.andreick.poo.domain;

import java.util.*;

public class Dev {

    private final String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public void inscrever(Collection<Conteudo> conteudos) {
        conteudosInscritos.addAll(conteudos);
    }

    public void concluir(Conteudo conteudo) {
        conteudosConcluidos.add(conteudo);
        conteudosInscritos.remove(conteudo);
    }

    public Optional<Conteudo> getPrimeiroConteudoInscrito() {
        return conteudosInscritos.stream().findFirst();
    }

    public Double getTotalXpConteudosConcluidos() {
        return conteudosConcluidos.stream().mapToDouble(Conteudo::getXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public List<Conteudo> getConteudosInscritos() {
        return List.copyOf(conteudosInscritos);
    }

    public List<Conteudo> getConteudosConcluidos() {
        return List.copyOf(conteudosConcluidos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return nome.equals(dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dev.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .toString();
    }
}
