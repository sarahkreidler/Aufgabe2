package de.kreidler.sarah.services;

import de.kreidler.sarah.domain.AggData;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.services.interfaces.DataAggregationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class DataAggregationServiceImpl implements DataAggregationService {

    @Override
    public List<Price> aggregateData(List<Mapping> mappings, List<Price> prices) {

        List<Price> result = new ArrayList<>();

        //Key to multipleValues
        Map<String, String> tradeids = new HashMap<>();
        tradeids.put("isin1", "tradeid1");
        tradeids.put("isin2", "tradeid2");
        tradeids.put("isin3", "tradeid3");
        tradeids.put("isin4", "tradeid4");

        //Entry means a pair of value; anhand des Keys wird der passende Wert ausgegeben
        for (Map.Entry pairEntry : tradeids.entrySet()) {
            System.out.println(pairEntry.getKey() + ": " + pairEntry.getValue());
        }

        //Mapping mappingObj = new Mapping();
        //List<Price> priceObj = new ArrayList<>();

        Map<Mapping, List<Price>> mappingPriceMap = new HashMap<>();

        for (Mapping mappingObj : mappings) {

            //Schleife über alle Preise überprüft, ob die Isin enthalten ist
            List <Price> pricesPerIsin = new ArrayList<>();
            for (Price elem:prices) {
                if (elem.getisin() == mappingObj.getisin()) {
                    pricesPerIsin.add(elem);
                    return pricesPerIsin;
                }
            }
            //Erzeuge mappingPriceMap für Isin1 und zugehörige Preise
            mappingPriceMap.put(mappingObj, pricesPerIsin);

                for (Map.Entry pairEntry : mappingPriceMap.entrySet()) {
                    System.out.println(pairEntry.getKey() + ": " + pairEntry.getValue());
                }
                 return result;
        }

        return result;
        //return null;
    }
}

