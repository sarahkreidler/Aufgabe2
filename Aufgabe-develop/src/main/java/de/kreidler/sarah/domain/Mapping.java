package de.kreidler.sarah.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Mapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //eine ISIN bzw. TradeId kann auf mehrere Preise gemappt werden
    @OneToMany(mappedBy="mapping")
    private Set<Price> prices;

    String isin;
    String tradeId;

    public Mapping() {
    }

    public Mapping(String isin, String tradeId) {
        this.isin = isin;
        this.tradeId = tradeId;
    }
}
