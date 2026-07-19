package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.Enum.BookingStatus;
import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Booking;
import com.example.SaveMySpot.entity.BookingSeat;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {

    private static final String GET_BOOKINGS_BY_USER_QUERY =
            "FROM Booking b WHERE b.userId = :userId ORDER BY b.bookingDate DESC";
    private static final String GET_BOOKINGS_BY_SHOW_QUERY =
            "FROM Booking b WHERE b.showId = :showId";
    private static final String GET_BOOKINGS_BY_STATUS_QUERY =
            "FROM Booking b WHERE b.bookingStatus = :status ORDER BY b.bookingDate DESC";
    private static final String GET_USER_BOOKING_HISTORY_QUERY =
            "SELECT b FROM Booking b JOIN Show s ON s.showId = b.showId " +
                    "JOIN Movie m ON m.movieId = s.movieId " +
                    "WHERE b.userId = :userId ORDER BY b.bookingDate DESC";
    private static final String COUNT_BOOKINGS_BY_USER_QUERY =
            "SELECT COUNT(b) FROM Booking b WHERE b.userId = :userId";

    @Override
    public void save(Booking booking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(booking);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to save booking.", exception);
        }
    }

    @Override
    public Booking findById(int bookingId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Booking.class, bookingId);
        } catch (Exception exception) {
            throw new RuntimeException("Unable to find booking.", exception);
        }
    }

    @Override
    public List<Booking> findByUser(int userId) {
        return List.of();
    }

    @Override
    public List<Booking> getBookingsByUser(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_BOOKINGS_BY_USER_QUERY, Booking.class)
                    .setParameter("userId", userId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch bookings by user.", exception);
        }
    }

    @Override
    public List<Booking> getBookingsByShow(int showId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_BOOKINGS_BY_SHOW_QUERY, Booking.class)
                    .setParameter("showId", showId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch bookings by show.", exception);
        }
    }

    @Override
    public List<Booking> getBookingsByStatus(String status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_BOOKINGS_BY_STATUS_QUERY, Booking.class)
                    .setParameter("status", status)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch bookings by status.", exception);
        }
    }

    @Override
    public List<Booking> getUserBookingHistory(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_USER_BOOKING_HISTORY_QUERY, Booking.class)
                    .setParameter("userId", userId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch user booking history.", exception);
        }
    }

    @Override
    public long countBookingsByUser(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(COUNT_BOOKINGS_BY_USER_QUERY, Long.class)
                    .setParameter("userId", userId)
                    .uniqueResult();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to count bookings by user.", exception);
        }
    }

    @Override
    public void update(Booking booking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(booking);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to update booking.", exception);
        }
    }

    @Override
    public void cancelBooking(int bookingId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Booking booking = session.get(Booking.class, bookingId);
            if (booking != null) {
                booking.setBookingStatus(BookingStatus.CANCELLED);
                session.merge(booking);
            }
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to cancel booking.", exception);
        }
    }

    @Override
    public List<BookingSeat> findByBooking(int bookingId) {
        return List.of();
    }
}