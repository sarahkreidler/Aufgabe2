package de.kreidler.sarah.services.interfaces;

import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.domain.JoinData;

import java.util.List;

public interface DataJoinService {

    List<JoinData> joinData (List<Mapping> mappings, List<Price> prices);

}
