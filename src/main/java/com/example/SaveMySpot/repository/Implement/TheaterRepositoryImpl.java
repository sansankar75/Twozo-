package com.example.SaveMySpot.repository.Implement;

import com.example.SaveMySpot.model.Theater;
import com.example.SaveMySpot.repository.Interface.TheaterRepository;
import com.example.SaveMySpot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TheaterRepositoryImpl implements TheaterRepository {

    @Override
    public void save(Theater theater) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(theater);

            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Failed to save theater.", exception);
        }
    }

    @Override
    public Theater findById(int theaterId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Theater.class, theaterId);

        } catch (Exception exception) {

            throw new RuntimeException("Failed to find theater.", exception);
        }
    }
}