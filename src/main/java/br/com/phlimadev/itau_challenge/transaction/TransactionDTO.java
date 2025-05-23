package br.com.phlimadev.itau_challenge.transaction;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionDTO(
        @NotNull
        BigDecimal valor,
        @NotNull
        OffsetDateTime dataHora
) {
}
