package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepositoryImpl implements UserRepository {

    public void addUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        } finally {
            session.close();
        }
    }

    @Override
    public User findById(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, userId);
        }
    }

    @Override
    public void update(User user) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        }
    }
}