package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Actor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActorRepositoryImpl implements ActorRepository {

    private static final String GET_ALL_ACTOR_QUERY = "FROM Actor ORDER BY actorName";
    private static final String GET_ACTOR_BY_MOVIE_QUERY =
            "SELECT a FROM Actor a JOIN MovieActor ma ON ma.actorId = a.actorId " +
                    "WHERE ma.movieId = :movie";
    private static final String SEARCH_ACTOR_BY_NAME_QUERY =
            "FROM Actor a WHERE LOWER(a.actorName) LIKE LOWER(:name)";

    @Override
    public void save(Actor actor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(actor);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to save actor.", exception);
        }
    }

    @Override
    public Actor findById(int actorId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Actor.class, actorId);
        } catch (Exception exception) {
            throw new RuntimeException("Unable to find actor.", exception);
        }
    }

    @Override
    public List<Actor> getAllActor() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_ACTOR_QUERY, Actor.class).getResultList();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch actors.", exception);
        }
    }

    @Override
    public List<Actor> getActorsByMovie(int movieId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_ACTOR_BY_MOVIE_QUERY, Actor.class)
                    .setParameter("movie", movieId)
                    .getResultList();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch movie actors.", exception);
        }
    }

    @Override
    public List<Actor> searchActorByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(SEARCH_ACTOR_BY_NAME_QUERY, Actor.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to search actors.", exception);
        }
    }

    @Override
    public void update(Actor actor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(actor);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to update actor.", exception);
        }
    }

    @Override
    public void delete(int actorId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Actor actor = session.get(Actor.class, actorId);
            if (actor != null) session.remove(actor);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to delete actor.", exception);
        }
    }
}