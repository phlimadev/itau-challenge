package com.example.itau_challenge.services;

import com.example.itau_challenge.dtos.TransactionDTO;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;

@Service
public class TransactionService {
    ArrayList<TransactionDTO> transactionList = new ArrayList<>();

    public void validateTransaction(TransactionDTO transaction) throws Exception {
        if (transaction.dataHora().isAfter(OffsetDateTime.now())) {
            throw new Exception("No transactions can be made in the future.");
        }
        if (transaction.valor() < 0) {
            throw new Exception("You cannot carry out negative value transactions.");
        }
    }

    public void createTransaction(TransactionDTO transaction) throws Exception {
        validateTransaction(transaction);
        transactionList.add(transaction);
    }

    public void deleteAllTransactions() {
        transactionList.clear();
    }
}
