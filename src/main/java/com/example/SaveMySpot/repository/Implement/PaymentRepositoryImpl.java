package com.example.SaveMySpot.repository.Implement;

import com.example.SaveMySpot.model.Payment;
import com.example.SaveMySpot.repository.Interface.PaymentRepository;
import com.example.SaveMySpot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaymentRepositoryImpl implements PaymentRepository {

    @Override
    public void save(Payment payment) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(payment);

            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Failed to save payment.", exception);
        }
    }

    @Override
    public Payment findByBooking(int bookingId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM Payment WHERE booking.bookingId = :bookingId",
                            Payment.class
                    )
                    .setParameter("bookingId", bookingId)
                    .uniqueResult();

        } catch (Exception exception) {

            throw new RuntimeException("Failed to find payment.", exception);
        }
    }
}