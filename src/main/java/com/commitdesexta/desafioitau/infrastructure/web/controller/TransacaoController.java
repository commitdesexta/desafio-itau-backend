package com.commitdesexta.desafioitau.infrastructure.web.controller;


import com.commitdesexta.desafioitau.application.port.input.CriarTransacaoUseCasePort;
import com.commitdesexta.desafioitau.application.port.input.DeletarTransacaoUseCasePort;
import com.commitdesexta.desafioitau.infrastructure.mapper.TrasacaoMapper;
import com.commitdesexta.desafioitau.infrastructure.web.controller.dto.TrasacaoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private final CriarTransacaoUseCasePort criarTransacaoUseCasePort;
    private final DeletarTransacaoUseCasePort deletarTransacaoUseCasePort;

    public TransacaoController(CriarTransacaoUseCasePort criarTransacaoUseCasePort, DeletarTransacaoUseCasePort deletarTransacaoUseCasePort) {
        this.criarTransacaoUseCasePort = criarTransacaoUseCasePort;
        this.deletarTransacaoUseCasePort = deletarTransacaoUseCasePort;
    }

    @PostMapping
    public ResponseEntity<Void> salva(@RequestBody TrasacaoRequest request){
        criarTransacaoUseCasePort.execute(TrasacaoMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(){
        deletarTransacaoUseCasePort.execute();
        return ResponseEntity.status(200).build();
    }
}
