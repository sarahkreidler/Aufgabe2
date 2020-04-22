package de.kreidler.sarah.services;

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
                               new Mapping("isin4", "tradeid4"));
        //hier werden Mappings gespeichert
        dao.save(fileMappings);
        //hier werden Mappings zurück gegeben
        List<Mapping> dbMappings = dao.getMappings();

        //Sarah: Vermutung ist, dass man für stream() Listen benötigt, daher zunächst exemplarisch 3 ISINs eingetragen
        List<Price> filePrices = fileDataLoader.getPrices();
        filePrices = List.of(new Price("01.01.2020", "isin1", 2),
                             new Price("02.01.2020", "isin1", 2),
                             new Price("03.01.2020", "isin1", 3));

        dao.savePrice(filePrices);
        List<Price> dbPrices = dao.getPrices();

        List<JoinData> joinData = dataJoinService.joinData(dbMappings, dbPrices);

        //List<AggData> aggData = dataAggregationService.aggregateData(dbMappings, dbPrices);

        //dataExportService.exportData(dbAggData)

    }
}
