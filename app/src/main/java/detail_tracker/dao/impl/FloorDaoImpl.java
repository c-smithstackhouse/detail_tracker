package detail_tracker.dao.impl;

import detail_tracker.entity.Floor;
import detail_tracker.dao.FloorDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class FloorDaoImpl implements FloorDao {
    private SessionFactory sessionFactory;

    public FloorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Floor getFloor(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Floor.class, id);
        }
    }

    @Override
    public List<Floor> getAllFloors() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Floor", Floor.class).list();
        }
    }

    @Override
    public void saveFloor(Floor floor) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(floor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFloor(Integer id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Floor floor = session.get(Floor.class, id);
            if (floor != null) {
                session.remove(floor);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}