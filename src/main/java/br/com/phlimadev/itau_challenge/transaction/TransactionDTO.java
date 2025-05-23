package br.com.phlimadev.itau_challenge.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionDTO(
        @NotNull
        BigDecimal valor,
        @NotNull
        @Past
        OffsetDateTime dataHora
) {
}
