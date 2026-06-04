package com.commitdesexta.desafioitau.application.port.output;

import com.commitdesexta.desafioitau.domain.Estatistica;
import com.commitdesexta.desafioitau.domain.Transacao;

public interface TransacaoRepositoryPort {
    void salvar(Transacao transacao);
    void deletar();
    Estatistica calcularEstatistica();
}
