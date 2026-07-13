package com.example.SaveMySpot.theater;

import com.example.SaveMySpot.common.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TheaterRepositoryImpl implements TheaterRepository {

    @Override
    public void save(Theater theater) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(theater);
            transaction.commit();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save theater.", exception);
        }
    }

    @Override
    public Theater findById(int theaterId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Theater.class, theaterId);

        } catch (Exception exception) {
            throw new RuntimeException("Failed to find theater.", exception);
        }
    }

    @Override
    public List<Theater> getAllTheater() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return  session.createQuery(
                    " FROM Theater" , Theater.class)
                    .getResultList();
        }
    }



}