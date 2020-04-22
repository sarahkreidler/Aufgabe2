package de.kreidler.sarah.services;

import de.kreidler.sarah.HibernateUtil;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.domain.JoinData;
import de.kreidler.sarah.services.interfaces.DataJoinService;
import org.hibernate.Session;

import java.util.List;

public class DataJoinServiceImpl implements DataJoinService {

    private List<JoinData> joinData;

    @Override
    public List<JoinData> joinData(List<Mapping> mappings, List<Price> prices) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction

            return session.createQuery("SELECT p.date, p.isin, p.price, m.tradeid FROM" +
                            " (SELECT date, isin, price FROM prices) p" +
                            " LEFT JOIN mappings m on p.isin = m.isin"
                    , JoinData.class).list();
        } catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println(joinData);
        return null;

    }

}
