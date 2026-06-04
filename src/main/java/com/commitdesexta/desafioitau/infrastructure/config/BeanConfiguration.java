package com.commitdesexta.desafioitau.infrastructure.config;

import com.commitdesexta.desafioitau.application.port.input.CalcularEstatisticaUseCasePort;
import com.commitdesexta.desafioitau.application.port.input.CriarTransacaoUseCasePort;
import com.commitdesexta.desafioitau.application.port.input.DeletarTransacaoUseCasePort;
import com.commitdesexta.desafioitau.application.port.output.TransacaoRepositoryPort;
import com.commitdesexta.desafioitau.application.usecase.CalcularEstatisticaUseCase;
import com.commitdesexta.desafioitau.application.usecase.CriarTransacaoUseCase;
import com.commitdesexta.desafioitau.application.usecase.DeletarTransacaoUseCase;
import com.commitdesexta.desafioitau.infrastructure.adapter.TransacaoRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {

    @Bean
    public CriarTransacaoUseCasePort criarTransacaoUseCasePort(TransacaoRepositoryPort transacaoRepositoryPort){
        return new CriarTransacaoUseCase(transacaoRepositoryPort);
    }
    @Bean
    public DeletarTransacaoUseCasePort deletarTransacaoUseCasePort(TransacaoRepositoryPort transacaoRepositoryPort){
        return new DeletarTransacaoUseCase(transacaoRepositoryPort);
    }

    @Bean
    public CalcularEstatisticaUseCasePort calcularEstatisticaUseCasePort(TransacaoRepositoryPort transacaoRepositoryPort){
        return new CalcularEstatisticaUseCase(transacaoRepositoryPort);
    }

    @Bean
    public TransacaoRepositoryPort transacaoRepositoryPort(){
        return new TransacaoRepositoryAdapter();
    }
}
