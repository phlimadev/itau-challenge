package br.com.phlimadev.itau_challenge.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionDTO(
        @NotNull
        @PositiveOrZero
        BigDecimal valor,
        @NotNull
        @Past
        OffsetDateTime dataHora
) {
}
