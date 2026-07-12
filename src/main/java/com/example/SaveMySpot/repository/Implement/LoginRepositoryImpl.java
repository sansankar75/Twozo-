package com.example.SaveMySpot.repository.Implement;

import com.example.SaveMySpot.model.User;
import com.example.SaveMySpot.repository.Interface.LoginRepository;
import com.example.SaveMySpot.util.HibernateUtil;
import org.hibernate.Session;

public class LoginRepositoryImpl implements LoginRepository {

    @Override
    public User findByEmail(String email) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM User WHERE email = :email",
                            User.class
                    )
                    .setParameter("email", email)
                    .uniqueResult();

        } catch (Exception exception) {

            throw new RuntimeException("Failed to find user by email.", exception);
        }
    }
}