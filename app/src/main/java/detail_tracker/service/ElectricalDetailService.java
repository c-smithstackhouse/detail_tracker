package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

import detail_tracker.entities.ElectricalDetail;
import detail_tracker.entities.ElectricalDeviceLkp;
import detail_tracker.entities.Note;
import detail_tracker.entities.Room;

public class ElectricalDetailService {

    @PersistenceContext
    private EntityManager entityManager;

    public ElectricalDetail createElectricalDetail(Room room, Note note, String location, ElectricalDeviceLkp electricalDevice, String brand, String model) {
        ElectricalDetail electricalDetail = new ElectricalDetail();
        electricalDetail.setRoom(room);
        electricalDetail.setNote(note);
        electricalDetail.setLocation(location);
        electricalDetail.setElectricalDevice(electricalDevice);
        electricalDetail.setBrand(brand);
        electricalDetail.setModel(model);

        entityManager.persist(electricalDetail);

        return electricalDetail;
    }

    public ElectricalDetail getElectricalDetail(int electricalDetId) {
        return entityManager.find(ElectricalDetail.class, electricalDetId);
    }

    public ElectricalDetail updateElectricalDetail(int electricalDetId, Room room, Note note, String location, ElectricalDeviceLkp electricalDevice, String brand, String model) {
        ElectricalDetail electricalDetail = entityManager.find(ElectricalDetail.class, electricalDetId);
        if (electricalDetail != null) {
            electricalDetail.setRoom(room);
            electricalDetail.setNote(note);
            electricalDetail.setLocation(location);
            electricalDetail.setElectricalDevice(electricalDevice);
            electricalDetail.setBrand(brand);
            electricalDetail.setModel(model);
        }

        return electricalDetail;
    }

    public void deleteElectricalDetail(int electricalDetId) {
        ElectricalDetail electricalDetail = entityManager.find(ElectricalDetail.class, electricalDetId);
        if (electricalDetail != null) {
            entityManager.remove(electricalDetail);
        }
    }

    public List<ElectricalDetail> getAllElectricalDetails() {
        TypedQuery<ElectricalDetail> query = entityManager.createQuery("SELECT e FROM ElectricalDetail e", ElectricalDetail.class);
        return query.getResultList();
    }

    // Additional methods

    public List<ElectricalDetail> findByRoom(Room room) {
        TypedQuery<ElectricalDetail> query = entityManager.createQuery("SELECT e FROM ElectricalDetail e WHERE e.room = :room", ElectricalDetail.class);
        query.setParameter("room", room);
        return query.getResultList();
    }

    public List<ElectricalDetail> findByElectricalDevice(ElectricalDeviceLkp electricalDevice) {
        TypedQuery<ElectricalDetail> query = entityManager.createQuery("SELECT e FROM ElectricalDetail e WHERE e.electricalDevice = :electricalDevice", ElectricalDetail.class);
        query.setParameter("electricalDevice", electricalDevice);
        return query.getResultList();
    }
}