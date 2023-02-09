package com.andreick.poo.service;

import com.andreick.poo.domain.*;
import com.andreick.poo.exception.DevException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DevServiceTest {

    private DevService devService;
    private Dev dev;
    private Bootcamp bootcamp;
    private List<Conteudo> conteudos;

    @BeforeEach
    public void iniciar() {

        devService = new DevService();

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
    public void O_Dev_Se_Inscreve_Em_Um_Bootcamp() {

        devService.inscreverBootcamp(dev, bootcamp);

        assertAll(
                () -> assertEquals(List.of(dev), bootcamp.getDevsInscritos(), "O Dev não foi inscrito no Bootcamp"),
                () -> assertEquals(conteudos, dev.getConteudosInscritos(), "O Dev não foi inscrito nos conteúdos do Bootcamp")
        );
    }

    @Test
    public void O_Dev_Conclui_Os_Conteudos_Na_Ordem_De_Inscricao() {

        devService.inscreverBootcamp(dev, bootcamp);

        conteudos.forEach(conteudo -> assertEquals(conteudo, devService.progredir(dev), "Conteúdo concluido na ordem incorreta"));
    }

    @Test
    public void O_Dev_Nao_Pode_Concluir_Um_Conteudo_Se_Nao_Estiver_Inscrito_Em_Nenhum() {

        assertThrows(DevException.class, () -> devService.progredir(dev));
    }

    @Test
    public void O_XP_Do_Dev_Eh_A_Soma_Do_XP_Dos_Seus_Conteudos_Concluidos() {

        double xpTotal = devService.calcularTotalXp(dev);

        devService.inscreverBootcamp(dev, bootcamp);

        int quantidadeConteudos = dev.getConteudosInscritos().size();

        for (int i = 0; i < quantidadeConteudos; i++) {
            var conteudo = devService.progredir(dev);
            xpTotal += conteudo.getXp();
        }

        assertEquals(xpTotal, devService.calcularTotalXp(dev));
    }
}
