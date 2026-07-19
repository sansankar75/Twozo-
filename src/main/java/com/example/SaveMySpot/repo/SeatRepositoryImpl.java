package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Seat;
import com.example.SaveMySpot.entity.ShowSeat;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SeatRepositoryImpl implements SeatRepository {

    private static final String GET_SEATS_BY_SCREEN_QUERY =
            "FROM Seat s WHERE s.screenId = :screenId ORDER BY s.rowName, s.seatNumber";
    private static final String GET_SEATS_BY_TYPE_QUERY =
            "FROM Seat s WHERE s.screenId = :screenId AND s.seatType = :seatType";

    @Override
    public void save(Seat seat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(seat);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to save seat.", exception);
        }
    }

    @Override
    public Seat findById(int seatId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Seat.class, seatId);
        } catch (Exception exception) {
            throw new RuntimeException("Unable to find seat.", exception);
        }
    }

    @Override
    public List<Seat> getSeatsByScreen(int screenId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_SEATS_BY_SCREEN_QUERY, Seat.class)
                    .setParameter("screenId", screenId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch seats by screen.", exception);
        }
    }

    @Override
    public List<Seat> getSeatsByType(int screenId, String seatType) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_SEATS_BY_TYPE_QUERY, Seat.class)
                    .setParameter("screenId", screenId)
                    .setParameter("seatType", seatType)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch seats by type.", exception);
        }
    }

    @Override
    public void delete(int seatId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Seat seat = session.get(Seat.class, seatId);
            if (seat != null) session.remove(seat);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to delete seat.", exception);
        }
    }


}