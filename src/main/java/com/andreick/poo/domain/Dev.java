package com.andreick.poo.domain;

import com.andreick.poo.exception.DevException;

import java.util.*;

public class Dev {

    private final String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.inscrever(this);
    }

    public Conteudo progredir() {
        var conteudo = conteudosInscritos.stream().findFirst()
                .orElseThrow(() -> new DevException("Dev sem conteúdo para concluir"));
        concluir(conteudo);
        return conteudo;
    }

    public Double calcularTotalXp() {
        return conteudosConcluidos.stream().mapToDouble(Conteudo::getXp).sum();
    }

    private void concluir(Conteudo conteudo) {
        conteudosConcluidos.add(conteudo);
        conteudosInscritos.remove(conteudo);
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
