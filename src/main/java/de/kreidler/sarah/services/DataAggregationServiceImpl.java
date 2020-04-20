package de.kreidler.sarah.services;

import de.kreidler.sarah.domain.AggData;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.services.interfaces.DataAggregationService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;

public class DataAggregationServiceImpl implements DataAggregationService {


    @Override
    public List<AggData> aggregateData(List<Mapping> mappings, List<Price> prices) {
        //Sarah: benötige Stream
        //Sarah: joine Mapping und Price über ISIN
        //Sarah: aggregiere pro TradeId und ISIN über Prices (zunächst mean )
        //Sarah: schreibe in AggData (TradeId, ISIN, MEAN)
        //Sarah: Vermutung: flatMap und collect

        return prices.stream()
                .collect(Collectors.groupingBy(
                        prices::getIsin,
                        Collectors.averagingInt(prices::getPrices)));
        System.out.println("Aggreate Data Here");
        return null;
    }
}
