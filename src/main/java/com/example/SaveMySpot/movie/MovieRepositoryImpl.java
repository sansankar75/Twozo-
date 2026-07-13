package com.example.SaveMySpot.movie;

import com.example.SaveMySpot.common.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {

    @Override
    public void save(Movie movie) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(movie);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save movie.", exception);
        }
    }

    @Override
    public Movie findById(int movieId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Movie.class, movieId);

        } catch (Exception exception) {
            throw new RuntimeException("Failed to find movie.", exception);
        }
    }

    @Override
    public List<Movie> findAll() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM Movie ORDER BY title",
                    Movie.class
            ).list();

        } catch (Exception exception) {
            throw new RuntimeException("Failed to fetch movies.", exception);
        }
    }

    @Override
    public void update(Movie movie) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(movie);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to update movie.", exception);
        }
    }

    @Override
    public void delete(int movieId) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Movie movie = session.get(Movie.class, movieId);
            if (movie != null) {
                session.remove(movie);
            }
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to delete movie.", exception);
        }
    }
}