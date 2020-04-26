package de.kreidler.sarah.domain;

import javax.persistence.*;

@Entity
public class AggData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String tradeid;
    private String isin;

    public AggData() {
    }

    public AggData(String tradeid, String isin) {
        this.tradeid = tradeid;
        this.isin = isin;
    }
}
