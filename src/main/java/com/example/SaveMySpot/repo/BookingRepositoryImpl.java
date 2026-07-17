package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Booking;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {

    @Override
    public void save(Booking booking) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(booking);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Unable to save booking.", exception);
        }
    }

    @Override
    public Booking findById(int bookingId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.find(Booking.class, bookingId);

        } catch (Exception exception) {
            throw new RuntimeException("Unable to find booking.", exception);
        }
    }

    @Override
    public List<Booking> findByUser(int userId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM Booking WHERE user.userId = :userId", Booking.class)
                    .setParameter("userId", userId)
                    .getResultList();

        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch bookings.", exception);
        }
    }
}