package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Actor;
import com.example.SaveMySpot.entity.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {

    private static final String GET_ALL_MOVIE_QUERY = "FROM Movie ORDER BY title";
    private static final String GET_MOVIE_BY_TITLE_QUERY =
            "FROM Movie m WHERE LOWER(m.title) LIKE LOWER(:title)";
    private static final String GET_MOVIE_BY_LANGUAGE_QUERY =
            "FROM Movie m WHERE m.language = :language ORDER BY m.releaseDate DESC";
    private static final String GET_UPCOMING_MOVIES_QUERY =
            "FROM Movie m WHERE m.releaseDate > :today ORDER BY m.releaseDate ASC";
    private static final String GET_NOW_SHOWING_MOVIES_QUERY =
            "SELECT DISTINCT m FROM Movie m JOIN Show s ON s.movieId = m.movieId " +
                    "WHERE s.showDate = :today";
    private static final String GET_ACTORS_BY_MOVIE_QUERY =
            "SELECT a FROM Actor a JOIN MovieActor ma ON ma.actorId = a.actorId " +
                    "WHERE ma.movieId = :movieId";
    private static final String GET_MOVIES_BY_GENRE_QUERY =
            "SELECT m FROM Movie m JOIN MovieGenre mg ON mg.movieId = m.movieId " +
                    "WHERE mg.genreId = :genreId";
    private static final String GET_MOVIE_COUNT_QUERY = "SELECT COUNT(m) FROM Movie m";

    @Override
    public void save(Movie movie) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(movie);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
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
    public List<Movie> findAllMovie() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_MOVIE_QUERY, Movie.class).list();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to fetch movies.", exception);
        }
    }

    @Override
    public List<Movie> searchMovieByTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_MOVIE_BY_TITLE_QUERY, Movie.class)
                    .setParameter("title", "%" + title + "%")
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to search movies.", exception);
        }
    }

    @Override
    public List<Movie> getMoviesByLanguage(String language) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_MOVIE_BY_LANGUAGE_QUERY, Movie.class)
                    .setParameter("language", language)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to fetch movies by language.", exception);
        }
    }

    @Override
    public List<Movie> getUpcomingMovies() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_UPCOMING_MOVIES_QUERY, Movie.class)
                    .setParameter("today", LocalDate.now())
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to fetch upcoming movies.", exception);
        }
    }

    @Override
    public List<Movie> getNowShowingMovies() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_NOW_SHOWING_MOVIES_QUERY, Movie.class)
                    .setParameter("today", LocalDate.now())
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to fetch now showing movies.", exception);
        }
    }

    @Override
    public List<Actor> getMovieActors(int movieId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_ACTORS_BY_MOVIE_QUERY, Actor.class)
                    .setParameter("movieId", movieId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to fetch movie actors.", exception);
        }
    }

    @Override
    public List<Movie> getMoviesByGenre(int genreId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_MOVIES_BY_GENRE_QUERY, Movie.class)
                    .setParameter("genreId", genreId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to fetch movies by genre.", exception);
        }
    }

    @Override
    public long countMovies() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_MOVIE_COUNT_QUERY, Long.class).uniqueResult();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to count movies.", exception);
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
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Failed to update movie.", exception);
        }
    }

    @Override
    public void delete(int movieId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Movie movie = session.get(Movie.class, movieId);
            if (movie != null) session.remove(movie);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Failed to delete movie.", exception);
        }
    }
}