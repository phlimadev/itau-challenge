package com.example.itau_challenge.controllers;

import com.example.itau_challenge.dtos.TransactionDTO;
import com.example.itau_challenge.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity createTransaction(@RequestBody @Valid TransactionDTO transaction) throws Exception {
        transactionService.createTransaction(transaction);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity deleteAllTransactions() {
        transactionService.deleteAllTransactions();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
