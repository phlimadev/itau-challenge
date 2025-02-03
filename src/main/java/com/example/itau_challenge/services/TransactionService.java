package com.example.itau_challenge.services;

import com.example.itau_challenge.dtos.StatisticsDTO;
import com.example.itau_challenge.dtos.TransactionDTO;
import com.example.itau_challenge.infra.exceptions.UnprocessableException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    ArrayList<TransactionDTO> transactionList = new ArrayList<>();

    public void validateTransaction(TransactionDTO transaction) {
        if (transaction.dataHora().isAfter(OffsetDateTime.now())) {
            throw new UnprocessableException();
        }
        if (transaction.valor() < 0) {
            throw new UnprocessableException();
        }
    }

    public void createTransaction(TransactionDTO transaction) throws Exception {
        validateTransaction(transaction);
        transactionList.add(transaction);
    }

    public void deleteAllTransactions() {
        transactionList.clear();
    }

    public StatisticsDTO calculateStatistics(Long seconds) {
        OffsetDateTime interval = OffsetDateTime.now().minusSeconds(seconds);
        List<TransactionDTO> filteredList = transactionList.stream().filter(transaction -> transaction.dataHora().isAfter(interval)).toList();
        if (filteredList.isEmpty()) {
            return new StatisticsDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }
        DoubleSummaryStatistics statistics = filteredList.stream().collect(Collectors.summarizingDouble(TransactionDTO::valor));
        return new StatisticsDTO(statistics.getCount(), statistics.getSum(), statistics.getAverage(), statistics.getMin(), statistics.getMax());
    }
}
