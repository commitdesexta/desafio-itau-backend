package com.commitdesexta.desafioitau.domain;

import com.commitdesexta.desafioitau.domain.exception.DomainException;

import java.time.OffsetDateTime;
import java.util.Objects;

public record Transacao (Double valor, OffsetDateTime dataHora) {
   public Transacao {
       if(Objects.isNull(valor) || Objects.isNull(dataHora)){
          throw new DomainException("Todos os campos devem ser preenchidos.");
       }
       if(valor < 0){
           throw new DomainException("Valor não pode ser menor que zero.");
       }
       if(dataHora.isAfter(OffsetDateTime.now())){
           throw new DomainException("Data não pode esta no futuro.");
       }
   }
}
