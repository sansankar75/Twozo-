package com.example.SaveMySpot.repository.Implement;

import com.example.SaveMySpot.model.Genre;
import com.example.SaveMySpot.repository.Interface.GenreRepository;
import com.example.SaveMySpot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GenreRepositoryImpl implements GenreRepository {

    @Override
    public void save(Genre genre) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.persist(genre);
            transaction.commit();

        } catch (Exception exception) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Failed to save genre.", exception);
        }
    }

    @Override
    public List<Genre> findAll() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM Genre ORDER BY genreName",
                    Genre.class
            ).list();

        } catch (Exception exception) {

            throw new RuntimeException("Failed to fetch genres.", exception);
        }
    }
}