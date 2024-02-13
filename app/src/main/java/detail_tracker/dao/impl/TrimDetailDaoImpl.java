package detail_tracker.dao.impl;

import detail_tracker.entity.TrimDetail;
import detail_tracker.dao.TrimDetailDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class TrimDetailDaoImpl implements TrimDetailDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TrimDetail findById(Integer id) {
        return entityManager.find(TrimDetail.class, id);
    }

    @Override
    public List<TrimDetail> findAll() {
        return entityManager.createQuery("SELECT t FROM TrimDetail t", TrimDetail.class).getResultList();
    }

    @Override
    public void save(TrimDetail trimDetail) {
        entityManager.persist(trimDetail);
    }

    @Override
    public void update(TrimDetail trimDetail) {
        entityManager.merge(trimDetail);
    }

    @Override
    public void delete(TrimDetail trimDetail) {
        entityManager.remove(entityManager.contains(trimDetail) ? trimDetail : entityManager.merge(trimDetail));
    }
}