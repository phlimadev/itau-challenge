package com.example.itau_challenge.dtos;

import java.time.OffsetDateTime;

public record TransactionDTO(Double valor, OffsetDateTime dataHora) {
}
