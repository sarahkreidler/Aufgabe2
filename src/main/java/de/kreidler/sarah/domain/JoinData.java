package de.kreidler.sarah.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class JoinData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    Mapping mappings;
    Price prices;

    public JoinData() {
    }

    public JoinData(String date, String isin, double price, String tradeid){
        mappings = new Mapping(isin, tradeid);
        prices = new Price(date, isin, price);
    }

}
