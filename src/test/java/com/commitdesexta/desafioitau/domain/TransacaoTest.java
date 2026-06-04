package com.commitdesexta.desafioitau.domain;

import com.commitdesexta.desafioitau.domain.exception.DomainException;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.instancio.junit.Seed;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(InstancioExtension.class)
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
        assertThrows(DomainException.class,() -> new Transacao(valor, dataHora));
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
        assertThrows(DomainException.class, () -> new Transacao(valor, dataHora));
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
        assertThrows(DomainException.class, () -> new Transacao(valor, dataHora));
    }

    @Test
    //@RepeatedTest(2000)
    void testInstacio(){
        OffsetDateTime minDataHora = OffsetDateTime.of(2024, 1,1,0,0,0, 0, ZoneOffset.UTC);
        OffsetDateTime maxDataHora = OffsetDateTime.now();

        Transacao transacao = Instancio.of(Transacao.class)
                .generate(field(Transacao::valor), gen -> gen.doubles().range(0d, 2000d))
                .generate(field(Transacao::dataHora), gen -> gen.temporal().offsetDateTime().range(minDataHora, maxDataHora))
                .create();
        assertTrue(transacao.dataHora().isAfter(minDataHora) && transacao.dataHora().isBefore(maxDataHora));
        assertTrue(transacao.valor() >= 0 && transacao.valor() <= 2000);
    }
}