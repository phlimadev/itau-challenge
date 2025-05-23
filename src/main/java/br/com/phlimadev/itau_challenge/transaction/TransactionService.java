package br.com.phlimadev.itau_challenge.transaction;

import br.com.phlimadev.itau_challenge.statistics.StatisticsDTO;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    List<TransactionDTO> transactions = new ArrayList<>();

    public void save(TransactionDTO transaction) {
        transactions.add(transaction);
    }

    public void clear() {
        transactions.clear();
    }

    private List<TransactionDTO> filterStatistics(Long seconds) {
        OffsetDateTime limit = OffsetDateTime.now().minusSeconds(seconds);
        return transactions.stream()
                .filter(transaction -> transaction.dataHora().isAfter(limit))
                .collect(Collectors.toList());
    }


    public StatisticsDTO getStatistics(Long seconds) {
        DoubleSummaryStatistics stats = filterStatistics(seconds).stream()
                .collect(Collectors.summarizingDouble(TransactionDTO::valor));

        return stats.getCount() == 0
                ? new StatisticsDTO(0L, 0.0, 0.0, 0.0, 0.0)
                : new StatisticsDTO(stats.getCount(), stats.getSum(), stats.getAverage(), stats.getMin(), stats.getMax());
    }

}
