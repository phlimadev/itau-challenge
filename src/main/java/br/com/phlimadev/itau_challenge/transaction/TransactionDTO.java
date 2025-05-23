package br.com.phlimadev.itau_challenge.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.OffsetDateTime;

public record TransactionDTO(
        @NotNull(message = "O campo 'valor' deve ser preenchido.")
        @PositiveOrZero(message = "A transação DEVE ter valor igual ou maior que 0 (zero)")
        Double valor,
        @NotNull(message = "O campo 'dataHora deve ser preenchido'")
        @Past(message = "A transação DEVE ter acontecido a qualquer momento no passado")
        OffsetDateTime dataHora
) {
}
