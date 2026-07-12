package com.example.SaveMySpot.repository.Implement;

import com.example.SaveMySpot.model.BookingSeat;
import com.example.SaveMySpot.repository.Interface.BookingSeatRepository;
import com.example.SaveMySpot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookingSeatRepositoryImpl implements BookingSeatRepository {

    @Override
    public void save(BookingSeat bookingSeat) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(bookingSeat);

            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Failed to save booking seat.", exception);
        }
    }

    @Override
    public List<BookingSeat> findByBooking(int bookingId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM BookingSeat bs WHERE bs.booking.bookingId = :bookingId",
                            BookingSeat.class)
                    .setParameter("bookingId", bookingId)
                    .getResultList();
        }
    }
}