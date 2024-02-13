package detail_tracker.dao.impl;

import detail_tracker.entity.PlumbingDetail;
import detail_tracker.dao.PlumbingDetailDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class PlumbingDetailDaoImpl implements PlumbingDetailDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PlumbingDetail findById(Integer id) {
        return entityManager.find(PlumbingDetail.class, id);
    }

    @Override
    public List<PlumbingDetail> findAll() {
        return entityManager.createQuery("SELECT p FROM PlumbingDetail p", PlumbingDetail.class).getResultList();
    }

    @Override
    public void save(PlumbingDetail plumbingDetail) {
        entityManager.persist(plumbingDetail);
    }

    @Override
    public void update(PlumbingDetail plumbingDetail) {
        entityManager.merge(plumbingDetail);
    }

    @Override
    public void delete(PlumbingDetail plumbingDetail) {
        entityManager.remove(entityManager.contains(plumbingDetail) ? plumbingDetail : entityManager.merge(plumbingDetail));
    }
}