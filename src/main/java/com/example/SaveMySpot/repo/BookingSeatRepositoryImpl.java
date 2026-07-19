package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.BookingSeat;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookingSeatRepositoryImpl implements BookingSeatRepository {

    private static final String GET_SEATS_BY_BOOKING_QUERY =
            "FROM BookingSeat bs WHERE bs.bookingId = :bookingId";
    private static final String GET_TOTAL_PRICE_BY_BOOKING_QUERY =
            "SELECT SUM(bs.price) FROM BookingSeat bs WHERE bs.bookingId = :bookingId";

    @Override
    public void save(BookingSeat bookingSeat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(bookingSeat);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to save booking seat.", exception);
        }
    }

    @Override
    public List<BookingSeat> findByBooking(int bookingId) {
        return List.of();
    }

    @Override
    public List<BookingSeat> getSeatsByBooking(int bookingId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_SEATS_BY_BOOKING_QUERY, BookingSeat.class)
                    .setParameter("bookingId", bookingId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch seats for booking.", exception);
        }
    }

    @Override
    public double getTotalPriceByBooking(int bookingId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Double total = session.createQuery(GET_TOTAL_PRICE_BY_BOOKING_QUERY, Double.class)
                    .setParameter("bookingId", bookingId)
                    .uniqueResult();
            return total != null ? total : 0.0;
        } catch (Exception exception) {
            throw new RuntimeException("Unable to calculate total price for booking.", exception);
        }
    }

    @Override
    public void delete(int bookingSeatId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            BookingSeat bookingSeat = session.get(BookingSeat.class, bookingSeatId);
            if (bookingSeat != null) session.remove(bookingSeat);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to delete booking seat.", exception);
        }
    }
}