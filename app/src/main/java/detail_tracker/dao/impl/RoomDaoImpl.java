package detail_tracker.dao.impl;

import detail_tracker.dao.RoomDao;
import detail_tracker.entities.Room;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RoomDaoImpl implements RoomDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Room findById(Integer id) {
        return entityManager.find(Room.class, id);
    }

    @Override
    public List<Room> findAll() {
        return entityManager.createQuery("SELECT r FROM Room r", Room.class).getResultList();
    }

    @Override
    public void save(Room room) {
        entityManager.persist(room);
    }

    @Override
    public void update(Room room) {
        entityManager.merge(room);
    }

    @Override
    public void delete(Room room) {
        entityManager.remove(entityManager.contains(room) ? room : entityManager.merge(room));
    }
}