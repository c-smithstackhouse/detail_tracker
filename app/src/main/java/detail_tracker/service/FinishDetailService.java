package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import detail_tracker.entity.FinishDetail;
import detail_tracker.entity.Room;
import detail_tracker.entity.Note;
import java.util.List;

public class FinishDetailService {

    @PersistenceContext
    private EntityManager entityManager;

    public FinishDetail createFinishDetail(Room room, Note note, String location, String material, String brand, String colorPattern, FinishDetail.Sheen sheen) {
        FinishDetail finishDetail = new FinishDetail();
        finishDetail.setRoom(room);
        finishDetail.setNote(note);
        finishDetail.setLocation(location);
        finishDetail.setMaterial(material);
        finishDetail.setBrand(brand);
        finishDetail.setColorPattern(colorPattern);
        finishDetail.setSheen(sheen);

        entityManager.persist(finishDetail);

        return finishDetail;
    }

    public FinishDetail getFinishDetail(int finishDetId) {
        return entityManager.find(FinishDetail.class, finishDetId);
    }

    public FinishDetail updateFinishDetail(int finishDetId, Room room, Note note, String location, String material, String brand, String colorPattern, FinishDetail.Sheen sheen) {
        FinishDetail finishDetail = entityManager.find(FinishDetail.class, finishDetId);
        if (finishDetail != null) {
            finishDetail.setRoom(room);
            finishDetail.setNote(note);
            finishDetail.setLocation(location);
            finishDetail.setMaterial(material);
            finishDetail.setBrand(brand);
            finishDetail.setColorPattern(colorPattern);
            finishDetail.setSheen(sheen);
        }

        return finishDetail;
    }

    public void deleteFinishDetail(int finishDetId) {
        FinishDetail finishDetail = entityManager.find(FinishDetail.class, finishDetId);
        if (finishDetail != null) {
            entityManager.remove(finishDetail);
        }
    }

    public List<FinishDetail> getAllFinishDetails() {
        TypedQuery<FinishDetail> query = entityManager.createQuery("SELECT f FROM FinishDetail f", FinishDetail.class);
        return query.getResultList();
    }

    // Additional methods

    public List<FinishDetail> findByRoom(Room room) {
        TypedQuery<FinishDetail> query = entityManager.createQuery("SELECT f FROM FinishDetail f WHERE f.room = :room", FinishDetail.class);
        query.setParameter("room", room);
        return query.getResultList();
    }

    public List<FinishDetail> findByMaterial(String material) {
        TypedQuery<FinishDetail> query = entityManager.createQuery("SELECT f FROM FinishDetail f WHERE f.material = :material", FinishDetail.class);
        query.setParameter("material", material);
        return query.getResultList();
    }
}