package com.commitdesexta.desafioitau.infrastructure.adapter;

import com.commitdesexta.desafioitau.application.port.output.TransacaoRepositoryPort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;

import java.util.Map;

public class MemoryHealthIndicator implements HealthIndicator {
    private static final Logger log = LogManager.getLogger();

    private final TransacaoRepositoryPort transacaoRepositoryPort;

    public MemoryHealthIndicator(TransacaoRepositoryPort transacaoRepositoryPort) {
        this.transacaoRepositoryPort = transacaoRepositoryPort;
    }

    @Override
    public Health health() {
        log.info("testando health");
        try{
            transacaoRepositoryPort.calcularEstatistica();
            return Health.up()
                    .withDetails(Map.of(
                            "componente", "Repositório em momoria",
                            "status","Operando normalmente"))
                    .build();
        }catch (Exception ex){
            return Health.down()
                    .withDetails(Map.of(
                            "erro", "Erro ao verificar repositório em momoria"))
                    .build();
        }
    }
}
