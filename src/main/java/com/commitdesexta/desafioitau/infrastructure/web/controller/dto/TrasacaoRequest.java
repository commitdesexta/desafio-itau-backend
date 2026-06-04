package com.commitdesexta.desafioitau.infrastructure.web.controller.dto;

import jakarta.annotation.Nonnull;

import java.time.OffsetDateTime;


public record TrasacaoRequest(double valor, OffsetDateTime dataHora) {
}
