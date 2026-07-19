package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.Screen;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ScreenRepositoryImpl implements ScreenRepository {

    private static final String GET_ALL_SCREEN_QUERY = "FROM Screen ORDER BY screenName";
    private static final String GET_SCREENS_BY_THEATER_QUERY =
            "FROM Screen sc WHERE sc.theaterId = :theaterId";

    @Override
    public void save(Screen screen) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(screen);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to save screen.", exception);
        }
    }

    @Override
    public List<Screen> findByTheater(int theaterId) {
        return List.of();
    }

    @Override
    public Screen findById(int screenId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Screen.class, screenId);
        } catch (Exception exception) {
            throw new RuntimeException("Unable to find screen.", exception);
        }
    }

    @Override
    public List<Screen> getAllScreen() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_SCREEN_QUERY, Screen.class).list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch screens.", exception);
        }
    }

    @Override
    public List<Screen> getScreensByTheater(int theaterId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_SCREENS_BY_THEATER_QUERY, Screen.class)
                    .setParameter("theaterId", theaterId)
                    .list();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to fetch screens by theater.", exception);
        }
    }

    @Override
    public void update(Screen screen) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(screen);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to update screen.", exception);
        }
    }

    @Override
    public void delete(int screenId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Screen screen = session.get(Screen.class, screenId);
            if (screen != null) session.remove(screen);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Unable to delete screen.", exception);
        }
    }
}