package com.commitdesexta.desafioitau.infrastructure.mapper;

import com.commitdesexta.desafioitau.domain.Estatistica;
import com.commitdesexta.desafioitau.infrastructure.web.controller.dto.EstatisticaResponse;

public class EstatisticaMapper {
    public static EstatisticaResponse toResponse(Estatistica estatistica){
        return new EstatisticaResponse(
                estatistica.count(),
                estatistica.sum(),
                estatistica.avg(),
                estatistica.min(),
                estatistica.max()
        );
    }
}
