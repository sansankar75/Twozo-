package com.example.SaveMySpot.show;

import com.example.SaveMySpot.common.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ShowSeatRepositoryImpl implements ShowSeatRepository {

    @Override
    public void save(ShowSeat showSeat) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(showSeat);
            transaction.commit();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save show seat.", exception);
        }
    }

    @Override
    public List<ShowSeat> findByShow(int showId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM ShowSeat WHERE show.showId = :showId", ShowSeat.class)
                    .setParameter("showId", showId)
                    .getResultList();

        } catch (Exception exception) {
            throw new RuntimeException("Failed to fetch show seats.", exception);
        }
    }

    @Override
    public void updateStatus(int showSeatId, ShowRepositoryImpl.SeatStatus status) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ShowSeat showSeat = session.get(ShowSeat.class, showSeatId);
            if (showSeat != null) {
                showSeat.setStatus(status);
                session.merge(showSeat);
            }
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to update seat status.", exception);
        }
    }

    public static class SeatNotAvailableException extends RuntimeException {
        public SeatNotAvailableException(String message) {
            super(message);
        }
    }
}
