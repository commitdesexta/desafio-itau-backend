package com.commitdesexta.desafioitau.domain;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;

public record Estatistica (long count, double sum, double avg, double min, double max){
    public static Estatistica gerarEstatisticas(List<Transacao> transacaos){
        if(Objects.isNull(transacaos) || transacaos.isEmpty()){
            return new Estatistica(0,0,0,0,0);
        }
        DoubleSummaryStatistics statistics = transacaos.stream().mapToDouble(Transacao::valor).summaryStatistics();
        return new Estatistica(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMin(),
                statistics.getMax()
        );
    }
}
