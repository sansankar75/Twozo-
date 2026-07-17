package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Actor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActorRepositoryImpl implements ActorRepository {

    private static final String
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
    public List<Actor> getAllActor() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Actor",
                    Actor.class
            ).getResultList();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch actors.", exception);
        }
    }

    @Override
    public List<Actor> getActorByMovie() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Actor",
                    Actor.class
            ).getResultList();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch actors.", exception);
    }
}