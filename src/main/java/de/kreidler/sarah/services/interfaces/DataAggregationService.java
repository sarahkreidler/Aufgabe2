package de.kreidler.sarah.services.interfaces;

import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;

import java.util.List;

public interface DataAggregationService {

    List<Price> aggregateData(List<Mapping> mappings, List<Price> prices);

}
