package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.ShowSeat;
import com.example.SaveMySpot.Enum.ShowStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class ShowSeatRepositoryImpl implements ShowSeatRepository {

    private static final String GET_SEATS_BY_SHOW_QUERY =
            "FROM ShowSeat ss WHERE ss.showId = :showId";
    private static final String GET_AVAILABLE_SEATS_BY_SHOW_QUERY =
            "FROM ShowSeat ss WHERE ss.showId = :showId AND ss.status = 'AVAILABLE'";
    private static final String GET_LOCKED_SEATS_QUERY =
            "FROM ShowSeat ss WHERE ss.showId = :showId AND ss.status = 'LOCKED' " +
                    "AND ss.lockedUntil < :now";
    private static final String COUNT_AVAILABLE_SEATS_QUERY =
            "SELECT COUNT(ss) FROM ShowSeat ss WHERE ss.showId = :showId AND ss.status = 'AVAILABLE'";

    @Override
    public void save(ShowSeat showSeat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(showSeat);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to save show seat.", exception);
        }
    }

    @Override
    public List<ShowSeat> findByShow(int showId) {
        return List.of();
    }


    @Override
    public ShowSeat findById(int showSeatId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ShowSeat.class, showSeatId);
        } catch (Exception exception) {
            throw new RuntimeException("Unable to find show seat.", exception);
        }
    }

    @Override
    public List<ShowSeat> getSeatsByShow(int showId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_SEATS_BY_SHOW_QUERY, ShowSeat.class)
                    .setParameter("showId", showId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch seats for show.", exception);
        }
    }

    @Override
    public List<ShowSeat> getAvailableSeatsByShow(int showId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_AVAILABLE_SEATS_BY_SHOW_QUERY, ShowSeat.class)
                    .setParameter("showId", showId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch available seats.", exception);
        }
    }

    @Override
    public List<ShowSeat> getExpiredLockedSeats(int showId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_LOCKED_SEATS_QUERY, ShowSeat.class)
                    .setParameter("showId", showId)
                    .setParameter("now", LocalDateTime.now())
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch expired locked seats.", exception);
        }
    }

    @Override
    public long countAvailableSeats(int showId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(COUNT_AVAILABLE_SEATS_QUERY, Long.class)
                    .setParameter("showId", showId)
                    .uniqueResult();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to count available seats.", exception);
        }
    }

    @Override
    public void update(ShowSeat showSeat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(showSeat);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to update show seat.", exception);
        }
    }
}