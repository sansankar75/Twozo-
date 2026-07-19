package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Theater;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TheaterRepositoryImpl implements TheaterRepository {

    private static final String GET_ALL_THEATER_QUERY = "FROM Theater ORDER BY name";
    private static final String GET_THEATER_BY_CITY_QUERY =
            "FROM Theater t WHERE LOWER(t.city) = LOWER(:city)";
    private static final String GET_THEATERS_SHOWING_MOVIE_QUERY =
            "SELECT DISTINCT t FROM Theater t " +
                    "JOIN Screen sc ON sc.theaterId = t.theaterId " +
                    "JOIN Show s ON s.screenId = sc.screenId " +
                    "WHERE s.movieId = :movieId AND s.showDate = :showDate";

    @Override
    public void save(Theater theater) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(theater);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to save theater.", exception);
        }
    }

    @Override
    public Theater findById(int theaterId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Theater.class, theaterId);
        } catch (Exception exception) {
            throw new RuntimeException("Unable to find theater.", exception);
        }
    }

    @Override
    public List<Theater> getAllTheater() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_THEATER_QUERY, Theater.class).list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch theaters.", exception);
        }
    }

    @Override
    public List<Theater> getTheatersByCity(String city) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_THEATER_BY_CITY_QUERY, Theater.class)
                    .setParameter("city", city)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch theaters by city.", exception);
        }
    }

    @Override
    public List<Theater> getTheatersShowingMovie(int movieId, java.time.LocalDate showDate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_THEATERS_SHOWING_MOVIE_QUERY, Theater.class)
                    .setParameter("movieId", movieId)
                    .setParameter("showDate", showDate)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch theaters showing movie.", exception);
        }
    }

    @Override
    public void update(Theater theater) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(theater);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to update theater.", exception);
        }
    }

    @Override
    public void delete(int theaterId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Theater theater = session.get(Theater.class, theaterId);
            if (theater != null) session.remove(theater);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to delete theater.", exception);
        }
    }
}