package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

import detail_tracker.entities.FlooringDetail;

public class FlooringDetailService {

    @PersistenceContext
    private EntityManager entityManager;

    public FlooringDetail createFlooringDetail(int roomId, int noteId, String material, String dimensions, String brand) {
        FlooringDetail detail = new FlooringDetail();
        detail.setRoomId(roomId);
        detail.setNoteId(noteId);
        detail.setMaterial(material);
        detail.setDimensions(dimensions);
        detail.setBrand(brand);

        entityManager.persist(detail);

        return detail;
    }

    public FlooringDetail getFlooringDetail(int flooringDetId) {
        return entityManager.find(FlooringDetail.class, flooringDetId);
    }

    public FlooringDetail updateFlooringDetail(int flooringDetId, int roomId, int noteId, String material, String dimensions, String brand) {
        FlooringDetail detail = entityManager.find(FlooringDetail.class, flooringDetId);
        if (detail != null) {
            detail.setRoomId(roomId);
            detail.setNoteId(noteId);
            detail.setMaterial(material);
            detail.setDimensions(dimensions);
            detail.setBrand(brand);
        }

        return detail;
    }

    public void deleteFlooringDetail(int flooringDetId) {
        FlooringDetail detail = entityManager.find(FlooringDetail.class, flooringDetId);
        if (detail != null) {
            entityManager.remove(detail);
        }
    }

    public List<FlooringDetail> getAllFlooringDetails() {
        TypedQuery<FlooringDetail> query = entityManager.createQuery("SELECT d FROM FlooringDetail d", FlooringDetail.class);
        return query.getResultList();
    }

    public List<FlooringDetail> getFlooringDetailsByRoomId(int roomId) {
        TypedQuery<FlooringDetail> query = entityManager.createQuery("SELECT d FROM FlooringDetail d WHERE d.roomId = :roomId", FlooringDetail.class);
        query.setParameter("roomId", roomId);
        return query.getResultList();
    }

    public List<FlooringDetail> getFlooringDetailsByMaterial(String material) {
        TypedQuery<FlooringDetail> query = entityManager.createQuery("SELECT d FROM FlooringDetail d WHERE d.material = :material", FlooringDetail.class);
        query.setParameter("material", material);
        return query.getResultList();
    }

    public List<FlooringDetail> getFlooringDetailsByBrand(String brand) {
        TypedQuery<FlooringDetail> query = entityManager.createQuery("SELECT d FROM FlooringDetail d WHERE d.brand = :brand", FlooringDetail.class);
        query.setParameter("brand", brand);
        return query.getResultList();
    }
}