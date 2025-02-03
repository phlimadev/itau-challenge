package com.example.itau_challenge.controllers;

import com.example.itau_challenge.dtos.StatisticsDTO;
import com.example.itau_challenge.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity getStatistics(@RequestParam(name = "seconds", defaultValue = "60") Long seconds) {
        StatisticsDTO statistics = transactionService.calculateStatistics(seconds);
        return ResponseEntity.ok(statistics);
    }
}
