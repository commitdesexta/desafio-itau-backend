package com.commitdesexta.desafioitau.application.usecase;

import com.commitdesexta.desafioitau.application.port.input.DeletarTransacaoUseCasePort;
import com.commitdesexta.desafioitau.application.port.output.TransacaoRepositoryPort;

public class DeletarTransacaoUseCase implements DeletarTransacaoUseCasePort {
    private final TransacaoRepositoryPort transacaoRepositoryPort;

    public DeletarTransacaoUseCase(TransacaoRepositoryPort transacaoRepositoryPort) {
        this.transacaoRepositoryPort = transacaoRepositoryPort;
    }

    @Override
    public void execute() {
        transacaoRepositoryPort.deletar();
    }
}
