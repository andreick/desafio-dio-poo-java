package com.andreick.poo.domain;

import java.util.*;

public class Dev {

    private final String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public void inscrever(Bootcamp bootcamp) {
        bootcamp.inscrever(this);
    }

    public void inscrever(Set<Conteudo> conteudos) {
        conteudosInscritos.addAll(conteudos);
    }

    public void progredir() {
        Optional<Conteudo> optConteudo = conteudosInscritos.stream().findFirst();
        optConteudo.ifPresentOrElse(conteudo -> {
            conteudosConcluidos.add(conteudo);
            conteudosInscritos.remove(conteudo);
        }, () -> System.err.println("Dev sem cursos inscritos"));
    }

    public Double calcularXp() {
        return conteudosConcluidos.stream().mapToDouble(Conteudo::getXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return Collections.unmodifiableSet(conteudosInscritos);
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return Collections.unmodifiableSet(conteudosConcluidos);
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
                .add("xp=" + calcularXp())
                .toString();
    }
}
