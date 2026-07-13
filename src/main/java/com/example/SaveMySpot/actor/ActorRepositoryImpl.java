package com.example.SaveMySpot.actor;

import com.example.SaveMySpot.common.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActorRepositoryImpl implements ActorRepository {

    @Override
    public void save(Actor actor) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(actor);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Unable to save actor.", exception);
        }
    }

    @Override
    public List<Actor> findAll() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Actor",
                    Actor.class
            ).getResultList();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch actors.", exception);
        }
    }
}