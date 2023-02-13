package com.andreick.poo.domain;

import com.andreick.poo.exception.DevException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DevTest {

    private Dev dev;
    private Bootcamp bootcamp;
    private List<Conteudo> conteudos;

    @BeforeEach
    public void iniciar() {

        conteudos = List.of(
                new Curso("curso js", "descrição curso js", 4),
                new Curso("curso java", "descrição curso java", 8),
                new Mentoria("mentoria de java", "descrição mentoria java", LocalDate.now())
        );

        bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
        bootcamp.adicionarConteudos(conteudos);

        dev = new Dev("Camila");
    }

    @Test
    @DisplayName("O Dev se inscreve em um Bootcamp")
    public void inscricaoBootcamp_Sucesso() {

        dev.inscreverBootcamp(bootcamp);

        assertAll(
                () -> assertEquals(List.of(dev), bootcamp.getDevsInscritos(), "O Dev não foi inscrito no Bootcamp"),
                () -> assertEquals(conteudos, dev.getConteudosInscritos(), "O Dev não foi inscrito nos conteúdos do Bootcamp")
        );
    }

    @Test
    @DisplayName("O Dev conclui os conteúdos na ordem de inscrição")
    public void ordemConclusaoConteudos_Sucesso() {

        dev.inscreverBootcamp(bootcamp);

        conteudos.forEach(conteudo -> assertEquals(conteudo, dev.progredir(), "Conteúdo concluido na ordem incorreta"));
    }

    @Test
    @DisplayName("O Dev não pode concluir um conteúdo se não estiver inscrito em nenhum")
    public void conclusaoSemConteudos_Exception() {

        assertThrows(DevException.class, () -> dev.progredir());
    }

    @Test
    @DisplayName("O XP do Dev é a soma do XP dos seus conteúdos concluídos")
    public void calculoXP_Sucesso() {

        double xpTotal = dev.calcularTotalXp();

        dev.inscreverBootcamp(bootcamp);

        int quantidadeConteudos = dev.getConteudosInscritos().size();

        for (int i = 0; i < quantidadeConteudos; i++) {
            var conteudo = dev.progredir();
            xpTotal += conteudo.getXp();
        }

        assertEquals(xpTotal, dev.calcularTotalXp());
    }
}
