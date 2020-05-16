package de.kreidler.sarah.services;

import de.kreidler.sarah.domain.AggData;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.dao.MarketDao;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.domain.JoinData;
import de.kreidler.sarah.services.interfaces.DataAggregationService;
import de.kreidler.sarah.services.interfaces.DataJoinService;
import de.kreidler.sarah.services.interfaces.DataProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Service("dataProcessor")
public class DataProcessorImpl implements DataProcessor {

    //csv-Daten werden eingelesen und in Liste geschrieben
    @Autowired
    private FileDataLoaderImpl fileDataLoader;

    @Autowired
    private MarketDao dao;

    @Autowired
    DataJoinService dataJoinService;

    @Autowired
    DataAggregationService dataAggregationService;

    @Override
    public void process() {

        List<Mapping> fileMappings = fileDataLoader.getMappings();
        fileMappings = List.of(new Mapping("isi1n", "tradeid1"),
                               new Mapping("isin2", "tradeid2"),
                               new Mapping("isin3", "tradeid3"),
                               new Mapping("isin3", "tradeid3")
                               );

        List<Mapping> dbMappings = dao.save(fileDataLoader.getMappings());
        //List<Mapping> dbMappings = dao.getMappings();

        List<Price> dbPrices = dao.savePrice(fileDataLoader.getPrices());
        //dao.savePrice(fileDataLoader.getPrices());
        //List<Price> dbPrices = dao.getPrices();

        List<AggData> aggData = dataAggregationService.aggregateData(dbMappings, dbPrices);

        //dataExportService.exportData(dbAggData)

    }
}
