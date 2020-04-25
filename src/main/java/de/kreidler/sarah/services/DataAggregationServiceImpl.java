package de.kreidler.sarah.services;

import de.kreidler.sarah.domain.AggData;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.services.interfaces.DataAggregationService;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class DataAggregationServiceImpl implements DataAggregationService {

    @Override
    public List<AggData> aggregateData(List<Mapping> mappings, List<Price> prices) {

        //Sarah: benötige Stream
        //Sarah: joine Mapping und Price über ISIN
        //Sarah: aggregiere pro TradeId und ISIN über Prices (zunächst mean )
        //Sarah: schreibe in AggData (TradeId, ISIN, MEAN)
        //Sarah: Vermutung: flatMap und collect

        //Map<Mapping, List<Price>> //mappe den key auf price
        //Map<Mapping, List<Price>> result = mappings.stream()
        //        .map(m -> m.getisin) //Stream<Set<String>>
        //        .flatMap(m --> m.stream()) //Stream<String>
        //        .collect(Collectors.groupingBy(Price::getIsin),
        //                 Collectors.averagingDouble(Price::getPrice));
        System.out.println("Aggreate Data Here");
        return null;
    }
}
