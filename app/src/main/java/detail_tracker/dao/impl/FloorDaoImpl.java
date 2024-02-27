package detail_tracker.dao.impl;

import detail_tracker.dao.FloorDao;
import detail_tracker.entities.Floor;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class FloorDaoImpl implements FloorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Floor findById(Integer id) {
        return entityManager.find(Floor.class, id);
    }

    @Override
    public List<Floor> findAll() {
        return entityManager.createQuery("SELECT f FROM Floor f", Floor.class).getResultList();
    }

    @Override
    public void save(Floor floor) {
        entityManager.persist(floor);
    }

    @Override
    public void update(Floor floor) {
        entityManager.merge(floor);
    }

    @Override
    public void delete(Floor floor) {
        entityManager.remove(entityManager.contains(floor) ? floor : entityManager.merge(floor));
    }
}