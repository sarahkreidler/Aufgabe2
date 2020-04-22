package de.kreidler.sarah.dao;

import de.kreidler.sarah.HibernateUtil;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.domain.JoinData;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MarketDao {

    public void save(List<Mapping> mappings) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(mappings.get(0));

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Mapping> getMappings() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction

            return session.createQuery("from Mapping", Mapping.class).list();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }


    public void savePrice(List<Price> prices) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(prices.get(0));

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Price> getPrices() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction

            return session.createQuery("from Price", Price.class).list();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    //Versuch über die Datenbank ein JOIN abzusetzen

    //public void saveResulttmp(List<Resulttmp> resulttmps) {

    //    Transaction transaction = null;
    //   try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    //       // start a transaction
    //        transaction = session.beginTransaction();
    //        // save the student objects
    //        session.save(resulttmps.get(0));

    //        // commit transaction
    //        transaction.commit();
    //    } catch (Exception e) {
    //       if (transaction != null) {
    //           transaction.rollback();
    //       }
    //       e.printStackTrace();
    //   }
    //}

    //public List<JoinData> getResulttmp() {

    //    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    //        // start a transaction

    //       return session.createQuery("SELECT p.date, p.isin, p.price, m.tradeid FROM" +
    //                                      " (SELECT date, isin, price FROM prices) p" +
    //                                      " LEFT JOIN mappings m on p.isin = m.isin"
    //                , JoinData.class).list();
                                                  //    } catch (Exception e) {

    //        e.printStackTrace();
                                                  //    }
    //    return null;
    //}

}
