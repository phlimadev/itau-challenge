package br.com.phlimadev.itau_challenge.statistics;

public record StatisticsDTO(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {
}
