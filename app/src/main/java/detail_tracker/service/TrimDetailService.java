package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

import detail_tracker.entities.TrimDetail;

public class TrimDetailService {

    @PersistenceContext
    private EntityManager entityManager;

    public TrimDetail createTrimDetail(int roomId, int noteId, String location, String material, String brand) {
        TrimDetail detail = new TrimDetail();
        detail.setRoomId(roomId);
        detail.setNoteId(noteId);
        detail.setLocation(location);
        detail.setMaterial(material);
        detail.setBrand(brand);

        entityManager.persist(detail);

        return detail;
    }

    public TrimDetail getTrimDetail(int trimDetId) {
        return entityManager.find(TrimDetail.class, trimDetId);
    }

    public TrimDetail updateTrimDetail(int trimDetId, int roomId, int noteId, String location, String material, String brand) {
        TrimDetail detail = entityManager.find(TrimDetail.class, trimDetId);
        if (detail != null) {
            detail.setRoomId(roomId);
            detail.setNoteId(noteId);
            detail.setLocation(location);
            detail.setMaterial(material);
            detail.setBrand(brand);
        }

        return detail;
    }

    public void deleteTrimDetail(int trimDetId) {
        TrimDetail detail = entityManager.find(TrimDetail.class, trimDetId);
        if (detail != null) {
            entityManager.remove(detail);
        }
    }

    public List<TrimDetail> getAllTrimDetails() {
        TypedQuery<TrimDetail> query = entityManager.createQuery("SELECT t FROM TrimDetail t", TrimDetail.class);
        return query.getResultList();
    }

    public List<TrimDetail> getTrimDetailsByRoomId(int roomId) {
        TypedQuery<TrimDetail> query = entityManager.createQuery("SELECT t FROM TrimDetail t WHERE t.roomId = :roomId", TrimDetail.class);
        query.setParameter("roomId", roomId);
        return query.getResultList();
    }

    public List<TrimDetail> getTrimDetailsByBrand(String brand) {
        TypedQuery<TrimDetail> query = entityManager.createQuery("SELECT t FROM TrimDetail t WHERE t.brand = :brand", TrimDetail.class);
        query.setParameter("brand", brand);
        return query.getResultList();
    }
}