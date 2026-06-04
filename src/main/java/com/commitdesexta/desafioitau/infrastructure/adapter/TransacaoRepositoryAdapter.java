package com.commitdesexta.desafioitau.infrastructure.adapter;

import ch.qos.logback.classic.model.LoggerModel;
import com.commitdesexta.desafioitau.application.port.output.TransacaoRepositoryPort;
import com.commitdesexta.desafioitau.domain.Estatistica;
import com.commitdesexta.desafioitau.domain.Transacao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TransacaoRepositoryAdapter implements TransacaoRepositoryPort {
    private static final Logger log = LogManager.getLogger();

    private final List<Transacao> transacaos = Collections.synchronizedList(new ArrayList<>());
    private final int tempoLimiteSegundos;
    public TransacaoRepositoryAdapter(int tempoLimiteSegundos) {
        this.tempoLimiteSegundos = tempoLimiteSegundos;
    }

    @Override
    public void salvar(Transacao transacao) {
        transacaos.add(transacao);
        log.info("Transação salva");
    }

    @Override
    public void deletar() {
        transacaos.clear();
        log.info("Transação deletada");
    }

    @Override
    public Estatistica calcularEstatistica() {
        log.info("Iniciando calculo estatistica {}s", tempoLimiteSegundos);
        synchronized (transacaos){
            OffsetDateTime tempoLimite = OffsetDateTime.now().minusSeconds(tempoLimiteSegundos);
            List<Transacao> lista = transacaos.stream().filter(t -> t.dataHora().isAfter(tempoLimite) || t.dataHora().equals(tempoLimite)).toList();
            log.info("Calculando lista com {} items", lista.size());
            return Estatistica.gerarEstatisticas(lista);
        }
    }

}
