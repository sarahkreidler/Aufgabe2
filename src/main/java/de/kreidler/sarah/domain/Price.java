package de.kreidler.sarah.domain;

import javax.persistence.*;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    public String date;
    public String isin;
    public double price;

    public Price() {
    }

    public Price(String date, String isin, double price) {
        this.date = date;
        this.isin = isin;
        this.price = price;
    }

}
