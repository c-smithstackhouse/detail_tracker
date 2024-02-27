package detail_tracker.dao.impl;

import detail_tracker.dao.FinishDetailDao;
import detail_tracker.entities.FinishDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class FinishDetailDaoImpl implements FinishDetailDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FinishDetail findById(Integer id) {
        return entityManager.find(FinishDetail.class, id);
    }

    @Override
    public List<FinishDetail> findAll() {
        return entityManager.createQuery("SELECT f FROM FinishDetail f", FinishDetail.class).getResultList();
    }

    @Override
    public void save(FinishDetail finishDetail) {
        entityManager.persist(finishDetail);
    }

    @Override
    public void update(FinishDetail finishDetail) {
        entityManager.merge(finishDetail);
    }

    @Override
    public void delete(FinishDetail finishDetail) {
        entityManager.remove(entityManager.contains(finishDetail) ? finishDetail : entityManager.merge(finishDetail));
    }
}