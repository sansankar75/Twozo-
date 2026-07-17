package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Show;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ShowRepositoryImpl implements ShowRepository {

    @Override
    public void save(Show show) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(show);
            transaction.commit();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save show.", exception);
        }
    }

    @Override
    public List<Show> findByMovie(int movieId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM Show WHERE movie.movieId = :movieId", Show.class)
                    .setParameter("movieId", movieId)
                    .getResultList();

        } catch (Exception exception) {
            throw new RuntimeException("Failed to fetch shows.", exception);
        }
    }

    @Override
    public Iterable<Object> findByScreen(int screenId) {
        return null;
    }

    public enum SeatStatus {
        AVAILABLE,
        BOOKED,
        RESERVED,
        UNAVAILABLE
    }
}