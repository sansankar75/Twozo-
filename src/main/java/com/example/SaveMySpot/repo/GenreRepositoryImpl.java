package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Genre;
import com.example.SaveMySpot.entity.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GenreRepositoryImpl implements GenreRepository {

    private static final String GET_ALL_GENRE_QUERY = "FROM Genre ORDER BY genreName";
    private static final String GET_GENRES_BY_MOVIE_QUERY =
            "SELECT g FROM Genre g JOIN MovieGenre mg ON mg.genreId = g.genreId " +
                    "WHERE mg.movieId = :movieId";
    private static final String GET_MOVIES_BY_GENRE_NAME_QUERY =
            "SELECT m FROM Movie m JOIN MovieGenre mg ON mg.movieId = m.movieId " +
                    "JOIN Genre g ON g.genreId = mg.genreId " +
                    "WHERE LOWER(g.genreName) = LOWER(:genreName)";

    @Override
    public void save(Genre genre) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(genre);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to save genre.", exception);
        }
    }

    @Override
    public List<Genre> findAll() {
        return List.of();
    }

    @Override
    public Genre findById(int genreId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Genre.class, genreId);
        } catch (Exception exception) {
            throw new RuntimeException("Unable to find genre.", exception);
        }
    }

    @Override
    public List<Genre> getAllGenre() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_GENRE_QUERY, Genre.class).list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch genres.", exception);
        }
    }

    @Override
    public List<Genre> getGenresByMovie(int movieId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_GENRES_BY_MOVIE_QUERY, Genre.class)
                    .setParameter("movieId", movieId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch genres for movie.", exception);
        }
    }

    @Override
    public List<Movie> getMoviesByGenreName(String genreName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_MOVIES_BY_GENRE_NAME_QUERY, Movie.class)
                    .setParameter("genreName", genreName)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch movies by genre name.", exception);
        }
    }

    @Override
    public void delete(int genreId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Genre genre = session.get(Genre.class, genreId);
            if (genre != null) session.remove(genre);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to delete genre.", exception);
        }
    }
}