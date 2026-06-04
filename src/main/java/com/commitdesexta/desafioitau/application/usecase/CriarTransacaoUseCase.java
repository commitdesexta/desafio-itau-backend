package com.commitdesexta.desafioitau.application.usecase;

import com.commitdesexta.desafioitau.application.port.input.CriarTransacaoUseCasePort;
import com.commitdesexta.desafioitau.application.port.output.TransacaoRepositoryPort;
import com.commitdesexta.desafioitau.domain.Transacao;

public class CriarTransacaoUseCase implements CriarTransacaoUseCasePort {
    private final TransacaoRepositoryPort transacaoRepositoryPort;

    public CriarTransacaoUseCase(TransacaoRepositoryPort transacaoRepositoryPort) {
        this.transacaoRepositoryPort = transacaoRepositoryPort;
    }


    @Override
    public void execute(Transacao transacao) {
        transacaoRepositoryPort.salvar(transacao);
    }
}
