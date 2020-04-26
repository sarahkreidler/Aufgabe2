package de.kreidler.sarah.services;

import de.kreidler.sarah.domain.AggData;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.services.interfaces.DataAggregationService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class DataAggregationServiceImpl implements DataAggregationService {

    @Override
    public List<AggData> aggregateData(List<Mapping> mappings, List<Price> prices) {

        List<AggData> result = new ArrayList<>();

        //Key to multipleValues
        Map<String, String> tradeids = new HashMap<>();
        tradeids.put("isin1", "tradeid1");
        tradeids.put("isin2", "tradeid2");
        tradeids.put("isin3", "tradeid3");
        tradeids.put("isin4", "tradeid4");

        //Entry means a pair of value; anhand des Keys wird der passende Wert ausgegeben
        for (Map.Entry pairEntry: tradeids.entrySet()){
            System.out.println(pairEntry.getKey() + ": " + pairEntry.getValue());
        }

        Map<Mapping, List<Price>> results = new HashMap<>();

        for(Map.Entry<Mapping, List<Price>> en : results.entrySet()){
            for(Object obj : en.getValue()){
                System.out.println(obj);
            }
        }

        return null;
    }
}
