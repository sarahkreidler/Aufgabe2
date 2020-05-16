package de.kreidler.sarah.domain;
import javax.persistence.*;

@Entity
public class Mapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    String isin;
    String tradeid;

    public Mapping() {
    }


    public Mapping(String isin, String tradeid) {
        this.isin = isin;
        this.tradeid = tradeid;
    }

    public String gettradeid(){
        return tradeid;
    }

    public String getisin() { return isin;}
    }



