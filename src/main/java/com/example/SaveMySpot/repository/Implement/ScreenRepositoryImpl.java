package com.example.SaveMySpot.repository.Implement;

import com.example.SaveMySpot.model.Screen;
import com.example.SaveMySpot.repository.Interface.ScreenRepository;
import com.example.SaveMySpot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ScreenRepositoryImpl implements ScreenRepository {

    @Override
    public void save(Screen screen) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(screen);

            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Failed to save screen.", exception);
        }
    }

    @Override
    public List<Screen> findByTheater(int theaterId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM Screen WHERE theater.theaterId = :theaterId",
                            Screen.class
                    )
                    .setParameter("theaterId", theaterId)
                    .getResultList();

        } catch (Exception exception) {

            throw new RuntimeException("Failed to fetch screens.", exception);
        }
    }
}