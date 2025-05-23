package br.com.phlimadev.itau_challenge.transaction;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionDTO(
        BigDecimal valor,
        OffsetDateTime dataHora
) {
}
