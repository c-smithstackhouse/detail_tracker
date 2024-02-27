package detail_tracker.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import detail_tracker.dao.ElectricalDetailDao;
import detail_tracker.entities.ElectricalDetail;

public class ElectricalDetailDaoImpl implements ElectricalDetailDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ElectricalDetail findById(Integer id) {
        return entityManager.find(ElectricalDetail.class, id);
    }

    @Override
    public List<ElectricalDetail> findAll() {
        return entityManager.createQuery("SELECT e FROM ElectricalDetail e", ElectricalDetail.class).getResultList();
    }

    @Override
    public void save(ElectricalDetail electricalDetail) {
        entityManager.persist(electricalDetail);
    }

    @Override
    public void update(ElectricalDetail electricalDetail) {
        entityManager.merge(electricalDetail);
    }

    @Override
    public void delete(ElectricalDetail electricalDetail) {
        entityManager.remove(entityManager.contains(electricalDetail) ? electricalDetail : entityManager.merge(electricalDetail));
    }
}