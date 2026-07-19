package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository {

    private static final String GET_PAYMENT_BY_BOOKING_QUERY =
            "FROM Payment p WHERE p.bookingId = :bookingId";
    private static final String GET_PAYMENTS_BY_STATUS_QUERY =
            "FROM Payment p WHERE p.paymentStatus = :status";
    private static final String GET_PAYMENT_BY_TRANSACTION_QUERY =
            "FROM Payment p WHERE p.transactionId = :transactionId";
    private static final String GET_TOTAL_REVENUE_QUERY =
            "SELECT SUM(p.amount) FROM Payment p WHERE p.paymentStatus = 'SUCCESS'";

    @Override
    public void save(Payment payment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(payment);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to save payment.", exception);
        }
    }

    @Override
    public Payment findByBooking(int bookingId) {
        return null;
    }

    @Override
    public Payment getPaymentByBooking(int bookingId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Payment> query = session.createQuery(GET_PAYMENT_BY_BOOKING_QUERY, Payment.class);
            query.setParameter("bookingId", bookingId);
            return query.uniqueResult();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch payment for booking.", exception);
        }
    }

    @Override
    public List<Payment> getPaymentsByStatus(String status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_PAYMENTS_BY_STATUS_QUERY, Payment.class)
                    .setParameter("status", status)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch payments by status.", exception);
        }
    }

    @Override
    public Payment getPaymentByTransactionId(String transactionId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Payment> query = session.createQuery(GET_PAYMENT_BY_TRANSACTION_QUERY, Payment.class);
            query.setParameter("transactionId", transactionId);
            return query.uniqueResult();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch payment by transaction id.", exception);
        }
    }

    @Override
    public double getTotalRevenue() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Double total = session.createQuery(GET_TOTAL_REVENUE_QUERY, Double.class).uniqueResult();
            return total != null ? total : 0.0;
        } catch (Exception exception) {
            throw new RuntimeException("Unable to calculate total revenue.", exception);
        }
    }

    @Override
    public void update(Payment payment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(payment);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to update payment.", exception);
        }
    }
}