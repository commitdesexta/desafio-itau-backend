package com.commitdesexta.desafioitau.infrastructure.web.controller;

import com.commitdesexta.desafioitau.application.port.input.CalcularEstatisticaUseCasePort;
import com.commitdesexta.desafioitau.infrastructure.mapper.EstatisticaMapper;
import com.commitdesexta.desafioitau.infrastructure.web.controller.dto.EstatisticaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
    private final CalcularEstatisticaUseCasePort calcularEstatisticaUseCasePort;

    public EstatisticaController(CalcularEstatisticaUseCasePort calcularEstatisticaUseCasePort) {
        this.calcularEstatisticaUseCasePort = calcularEstatisticaUseCasePort;
    }

    @GetMapping
    public ResponseEntity<EstatisticaResponse> calcularEstatistica(){
        EstatisticaResponse reponseBody = EstatisticaMapper.toResponse(calcularEstatisticaUseCasePort.execute());
        return ResponseEntity.ok(reponseBody);
    }
}
