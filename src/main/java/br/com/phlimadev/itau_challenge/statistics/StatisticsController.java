package br.com.phlimadev.itau_challenge.statistics;

import br.com.phlimadev.itau_challenge.transaction.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
    private final TransactionService transactionService;

    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsDTO> getStatistics(@RequestParam(defaultValue = "60") Long seconds) {
        return ResponseEntity.ok(transactionService.getStatistics(seconds));
    }
}
