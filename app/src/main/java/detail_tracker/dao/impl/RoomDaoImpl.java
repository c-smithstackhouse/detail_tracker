package detail_tracker.dao.impl;

import detail_tracker.dao.RoomDao;
import detail_tracker.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    private SessionFactory sessionFactory;

    public RoomDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Room getRoom(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Room.class, id);
        }
    }

    @Override
    public List<Room> getAllRooms() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Room", Room.class).list();
        }
    }

    @Override
    public void saveRoom(Room room) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(room);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(Integer id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Room room = session.find(Room.class, id);
            if (room != null) {
                session.remove(room);
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