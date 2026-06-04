package com.commitdesexta.desafioitau.application.port.input;

import com.commitdesexta.desafioitau.domain.Transacao;

public interface CriarTransacaoUseCasePort {
    void execute(Transacao transacao);
}
