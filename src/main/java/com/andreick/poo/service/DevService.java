package com.andreick.poo.service;

import com.andreick.poo.domain.Bootcamp;
import com.andreick.poo.domain.Conteudo;
import com.andreick.poo.domain.Dev;
import com.andreick.poo.exception.DevException;

public class DevService {

    public void inscreverBootcamp(Dev dev, Bootcamp bootcamp) {
        bootcamp.inscrever(dev);
        dev.inscrever(bootcamp.getConteudos());
    }

    public void progredir(Dev dev) {
        var conteudo = dev.getConteudosInscritos().stream().findFirst()
                .orElseThrow(() -> new DevException("Dev sem conteúdo para concluir"));
        dev.concluir(conteudo);
    }

    public Double calcularTotalXp(Dev dev) {
        return dev.getConteudosConcluidos().stream().mapToDouble(Conteudo::getXp).sum();
    }
}
