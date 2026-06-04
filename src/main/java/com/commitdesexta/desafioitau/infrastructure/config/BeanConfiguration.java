package com.commitdesexta.desafioitau.infrastructure.config;

import com.commitdesexta.desafioitau.application.port.input.CalcularEstatisticaUseCasePort;
import com.commitdesexta.desafioitau.application.port.input.CriarTransacaoUseCasePort;
import com.commitdesexta.desafioitau.application.port.input.DeletarTransacaoUseCasePort;
import com.commitdesexta.desafioitau.application.port.output.TransacaoRepositoryPort;
import com.commitdesexta.desafioitau.application.usecase.CalcularEstatisticaUseCase;
import com.commitdesexta.desafioitau.application.usecase.CriarTransacaoUseCase;
import com.commitdesexta.desafioitau.application.usecase.DeletarTransacaoUseCase;
import com.commitdesexta.desafioitau.infrastructure.adapter.MemoryHealthIndicator;
import com.commitdesexta.desafioitau.infrastructure.adapter.TransacaoRepositoryAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Value("${estatistica.tempo-limite}")
    private int tempoLimiteSegundos;

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
        return new TransacaoRepositoryAdapter(tempoLimiteSegundos);
    }

    @Bean
    public MemoryHealthIndicator memoryHealthIndicator(TransacaoRepositoryPort transacaoRepositoryPort){
        return new MemoryHealthIndicator(transacaoRepositoryPort);
    }
}
