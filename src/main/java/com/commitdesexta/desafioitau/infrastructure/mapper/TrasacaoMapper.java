package com.commitdesexta.desafioitau.infrastructure.mapper;

import com.commitdesexta.desafioitau.domain.Transacao;
import com.commitdesexta.desafioitau.infrastructure.web.controller.dto.TrasacaoRequest;

public class TrasacaoMapper {
    public static Transacao toDomain(TrasacaoRequest request) {
        return new Transacao(request.valor(), request.dataHora());
    }
}
