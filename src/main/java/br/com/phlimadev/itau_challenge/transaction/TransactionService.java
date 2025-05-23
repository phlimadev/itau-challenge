package br.com.phlimadev.itau_challenge.transaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    List<TransactionDTO> transactions;

    public void save(TransactionDTO transaction) {
        transactions.add(transaction);
    }

    public void clear() {
        transactions.clear();
    }
}
