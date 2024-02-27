package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

import detail_tracker.entities.Note;
import detail_tracker.entities.PlumbingDetail;
import detail_tracker.entities.PlumbingFixtureLkp;
import detail_tracker.entities.Room;

public class PlumbingDetailService {

    @PersistenceContext
    private EntityManager entityManager;

    public PlumbingDetail createPlumbingDetail(Room room, Note note, PlumbingFixtureLkp plumbingFixture, String brand, String model, String location) {
        PlumbingDetail detail = new PlumbingDetail();
        detail.setRoom(room);
        detail.setNote(note);
        detail.setPlumbingFixture(plumbingFixture);
        detail.setBrand(brand);
        detail.setModel(model);
        detail.setLocation(location);

        entityManager.persist(detail);

        return detail;
    }

    public PlumbingDetail getPlumbingDetail(int plumbingDetId) {
        return entityManager.find(PlumbingDetail.class, plumbingDetId);
    }

    public PlumbingDetail updatePlumbingDetail(int plumbingDetId, Room room, Note note, PlumbingFixtureLkp plumbingFixture, String brand, String model, String location) {
        PlumbingDetail detail = entityManager.find(PlumbingDetail.class, plumbingDetId);
        if (detail != null) {
            detail.setRoom(room);
            detail.setNote(note);
            detail.setPlumbingFixture(plumbingFixture);
            detail.setBrand(brand);
            detail.setModel(model);
            detail.setLocation(location);
        }

        return detail;
    }

    public void deletePlumbingDetail(int plumbingDetId) {
        PlumbingDetail detail = entityManager.find(PlumbingDetail.class, plumbingDetId);
        if (detail != null) {
            entityManager.remove(detail);
        }
    }

    public List<PlumbingDetail> getAllPlumbingDetails() {
        TypedQuery<PlumbingDetail> query = entityManager.createQuery("SELECT p FROM PlumbingDetail p", PlumbingDetail.class);
        return query.getResultList();
    }

    public List<PlumbingDetail> getPlumbingDetailsByRoom(Room room) {
        TypedQuery<PlumbingDetail> query = entityManager.createQuery("SELECT p FROM PlumbingDetail p WHERE p.room = :room", PlumbingDetail.class);
        query.setParameter("room", room);
        return query.getResultList();
    }

    public List<PlumbingDetail> getPlumbingDetailsByBrand(String brand) {
        TypedQuery<PlumbingDetail> query = entityManager.createQuery("SELECT p FROM PlumbingDetail p WHERE p.brand = :brand", PlumbingDetail.class);
        query.setParameter("brand", brand);
        return query.getResultList();
    }

    public List<PlumbingDetail> getPlumbingDetailsByModel(String model) {
        TypedQuery<PlumbingDetail> query = entityManager.createQuery("SELECT p FROM PlumbingDetail p WHERE p.model = :model", PlumbingDetail.class);
        query.setParameter("model", model);
        return query.getResultList();
    }
}