package detail_tracker.dao.impl;

import detail_tracker.dao.FlooringDetailDao;
import detail_tracker.entities.FlooringDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class FlooringDetailDaoImpl implements FlooringDetailDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FlooringDetail findById(Integer id) {
        return entityManager.find(FlooringDetail.class, id);
    }

    @Override
    public List<FlooringDetail> findAll() {
        return entityManager.createQuery("SELECT f FROM FlooringDetail f", FlooringDetail.class).getResultList();
    }

    @Override
    public void save(FlooringDetail flooringDetail) {
        entityManager.persist(flooringDetail);
    }

    @Override
    public void update(FlooringDetail flooringDetail) {
        entityManager.merge(flooringDetail);
    }

    @Override
    public void delete(FlooringDetail flooringDetail) {
        entityManager.remove(entityManager.contains(flooringDetail) ? flooringDetail : entityManager.merge(flooringDetail));
    }
}