package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.User;
import com.example.SaveMySpot.exception.LoginException;
import org.hibernate.Session;

public class LoginRepositoryImpl implements LoginRepository {

    @Override
    public User findByEmail(String email) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM User WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } catch (Exception exception) {
            throw new LoginException("Failed to find user by email." + exception);
        }
    }
}