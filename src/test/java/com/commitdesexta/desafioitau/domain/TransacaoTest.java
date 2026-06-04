package com.commitdesexta.desafioitau.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoTest {
    @Test
    void testTransacaoDeveSerValida(){
        int year = LocalDate.now().getYear();
        double valor = 123.45;
        OffsetDateTime dataHora = OffsetDateTime.of(year, 1,1,0,0,0, 0, ZoneOffset.UTC);
        Transacao transacao = new Transacao(valor, dataHora);
        assertEquals(valor, transacao.valor());
        assertEquals(dataHora, transacao.dataHora());
    }

    @Test
    void testTransacaoEstaNoFuturo(){
        int year = LocalDate.now().getYear() + 20;
        double valor = 123.45;
        OffsetDateTime dataHora = OffsetDateTime.of(year, 1,1,0,0,0, 0, ZoneOffset.UTC);
        assertThrows(IllegalArgumentException.class,() -> new Transacao(valor, dataHora));
    }

    @Test
    void testTrasacaoDeveSerValidaComDataNoPassado(){
        int year = LocalDate.now().getYear() - 2;
        double valor = 123.45;
        OffsetDateTime dataHora = OffsetDateTime.of(year, 1,1,0,0,0, 0, ZoneOffset.UTC);
        Transacao transacao = new Transacao(valor, dataHora);
        assertEquals(valor, transacao.valor());
        assertEquals(dataHora, transacao.dataHora());
    }

    @Test
    void testTransacaoNaoDeveTerValorNegativo(){
        int year = LocalDate.now().getYear() - 2;
        double valor = -123.45;
        OffsetDateTime dataHora = OffsetDateTime.of(year, 1,1,0,0,0, 0, ZoneOffset.UTC);
        assertThrows(IllegalArgumentException.class, () -> new Transacao(valor, dataHora));
    }

    @Test
    void testTransacaoDeveSerValidaComValorZero(){
        int year = LocalDate.now().getYear();
        double valor = 0;
        OffsetDateTime dataHora = OffsetDateTime.of(year, 1,1,0,0,0, 0, ZoneOffset.UTC);
        Transacao transacao = new Transacao(valor, dataHora);
        assertEquals(valor, transacao.valor());
        assertEquals(dataHora, transacao.dataHora());
    }

    @Test
    void testTrasacaoNaoDeveTerNenhumCampoNull(){
        double valor = 0;
        OffsetDateTime dataHora = null;
        assertThrows(IllegalArgumentException.class, () -> new Transacao(valor, dataHora));
    }
}