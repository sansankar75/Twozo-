package com.example.SaveMySpot.repository.Implement;

import com.example.SaveMySpot.model.Show;
import com.example.SaveMySpot.repository.Interface.ShowRepository;
import com.example.SaveMySpot.util.HibernateUtil;
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
                            "FROM Show WHERE movie.movieId = :movieId",
                            Show.class
                    )
                    .setParameter("movieId", movieId)
                    .getResultList();

        } catch (Exception exception) {

            throw new RuntimeException("Failed to fetch shows.", exception);
        }
    }
}