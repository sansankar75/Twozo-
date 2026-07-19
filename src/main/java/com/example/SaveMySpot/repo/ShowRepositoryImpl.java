package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Show;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class ShowRepositoryImpl implements ShowRepository {

    private static final String GET_SHOWS_BY_MOVIE_QUERY =
            "FROM Show s WHERE s.movieId = :movieId ORDER BY s.showDate, s.startTime";
    private static final String GET_SHOWS_BY_MOVIE_AND_DATE_QUERY =
            "FROM Show s WHERE s.movieId = :movieId AND s.showDate = :showDate " +
                    "ORDER BY s.startTime";
    private static final String GET_SHOWS_BY_SCREEN_QUERY =
            "FROM Show s WHERE s.screenId = :screenId AND s.showDate = :showDate " +
                    "ORDER BY s.startTime";
    private static final String GET_SHOWS_BY_THEATER_AND_MOVIE_QUERY =
            "SELECT s FROM Show s JOIN Screen sc ON sc.screenId = s.screenId " +
                    "WHERE sc.theaterId = :theaterId AND s.movieId = :movieId AND s.showDate = :showDate";

    @Override
    public void save(Show show) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(show);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to save show.", exception);
        }
    }

    @Override
    public List<Show> findByMovie(int movieId) {
        return List.of();
    }

    @Override
    public Iterable<Object> findByScreen(int screenId) {
        return null;
    }

    @Override
    public Show findById(int showId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Show.class, showId);
        } catch (Exception exception) {
            throw new RuntimeException("Unable to find show.", exception);
        }
    }

    @Override
    public List<Show> getShowsByMovie(int movieId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_SHOWS_BY_MOVIE_QUERY, Show.class)
                    .setParameter("movieId", movieId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch shows by movie.", exception);
        }
    }

    @Override
    public List<Show> getShowsByMovieAndDate(int movieId, LocalDate showDate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_SHOWS_BY_MOVIE_AND_DATE_QUERY, Show.class)
                    .setParameter("movieId", movieId)
                    .setParameter("showDate", showDate)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch shows by movie and date.", exception);
        }
    }

    @Override
    public List<Show> getShowsByScreenAndDate(int screenId, LocalDate showDate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_SHOWS_BY_SCREEN_QUERY, Show.class)
                    .setParameter("screenId", screenId)
                    .setParameter("showDate", showDate)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch shows by screen and date.", exception);
        }
    }

    @Override
    public List<Show> getShowsByTheaterAndMovie(int theaterId, int movieId, LocalDate showDate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_SHOWS_BY_THEATER_AND_MOVIE_QUERY, Show.class)
                    .setParameter("theaterId", theaterId)
                    .setParameter("movieId", movieId)
                    .setParameter("showDate", showDate)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch shows by theater and movie.", exception);
        }
    }

    @Override
    public void update(Show show) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(show);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to update show.", exception);
        }
    }

    @Override
    public void delete(int showId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Show show = session.get(Show.class, showId);
            if (show != null) session.remove(show);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to delete show.", exception);
        }
    }
}