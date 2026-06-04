package com.commitdesexta.desafioitau.application.usecase;

import com.commitdesexta.desafioitau.application.port.input.CalcularEstatisticaUseCasePort;
import com.commitdesexta.desafioitau.application.port.output.TransacaoRepositoryPort;
import com.commitdesexta.desafioitau.domain.Estatistica;

public class CalcularEstatisticaUseCase implements CalcularEstatisticaUseCasePort {
    private final TransacaoRepositoryPort transacaoRepositoryPort;

    public CalcularEstatisticaUseCase(TransacaoRepositoryPort transacaoRepositoryPort) {
        this.transacaoRepositoryPort = transacaoRepositoryPort;
    }

    @Override
    public Estatistica execute() {
        return transacaoRepositoryPort.calcularEstatistica();
    }
}
