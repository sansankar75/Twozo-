package com.example.SaveMySpot.Enum;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.ShowSeat;
import com.example.SaveMySpot.service.ShowService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public enum ShowStatus {
    SCHEDULED,
    CANCELLED,
    COMPLETED,
    RUNNING;

    public static class SeatRepositoryImpl implements ShowService.SeatRepository {

        @Override
        public void save(ShowSeat.Seat seat) {
            Transaction transaction = null;

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.persist(seat);
                transaction.commit();
            } catch (Exception exception) {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw new RuntimeException("Failed to save seat.", exception);
            }
        }

        @Override
        public List<ShowSeat.Seat> findByScreen(int screenId) {

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {

                return session.createQuery(
                                "FROM Seat WHERE screen.screenId = :screenId", ShowSeat.Seat.class)
                        .setParameter("screenId", screenId)
                        .getResultList();

            } catch (Exception exception) {
                throw new RuntimeException("Failed to fetch seats.", exception);
            }
        }
    }
}
