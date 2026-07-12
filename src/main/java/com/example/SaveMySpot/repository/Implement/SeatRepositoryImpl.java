package com.example.SaveMySpot.repository.Implement;

import com.example.SaveMySpot.model.Seat;
import com.example.SaveMySpot.repository.Interface.SeatRepository;
import com.example.SaveMySpot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SeatRepositoryImpl implements SeatRepository {

    @Override
    public void save(Seat seat) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(seat);

            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Failed to save seat.", exception);
        }
    }

    @Override
    public List<Seat> findByScreen(int screenId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM Seat WHERE screen.screenId = :screenId",
                            Seat.class
                    )
                    .setParameter("screenId", screenId)
                    .getResultList();

        } catch (Exception exception) {

            throw new RuntimeException("Failed to fetch seats.", exception);
        }
    }
}