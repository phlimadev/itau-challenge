package br.com.phlimadev.itau_challenge.transaction;

import br.com.phlimadev.itau_challenge.statistics.StatisticsDTO;
import org.springframework.stereotype.Service;

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

    public StatisticsDTO getStatistics() {
        DoubleSummaryStatistics statistics = transactions.stream().collect(Collectors.summarizingDouble(TransactionDTO::valor));
        return new StatisticsDTO(statistics.getCount(), statistics.getSum(), statistics.getAverage(), statistics.getMin(), statistics.getMax());
    }
}
