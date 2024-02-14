package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import detail_tracker.entity.Floor;
import java.util.List;

public class FloorService {

    @PersistenceContext
    private EntityManager entityManager;

    public Floor createFloor(Floor.FloorType floorType, String archCode) {
        Floor floor = new Floor();
        floor.setFloorType(floorType);
        floor.setArchCode(archCode);

        entityManager.persist(floor);

        return floor;
    }

    public Floor getFloor(int floorId) {
        return entityManager.find(Floor.class, floorId);
    }

    public Floor updateFloor(int floorId, Floor.FloorType floorType, String archCode) {
        Floor floor = entityManager.find(Floor.class, floorId);
        if (floor != null) {
            floor.setFloorType(floorType);
            floor.setArchCode(archCode);
        }

        return floor;
    }

    public void deleteFloor(int floorId) {
        Floor floor = entityManager.find(Floor.class, floorId);
        if (floor != null) {
            entityManager.remove(floor);
        }
    }

    public List<Floor> getAllFloors() {
        TypedQuery<Floor> query = entityManager.createQuery("SELECT f FROM Floor f", Floor.class);
        return query.getResultList();
    }

    public List<Floor> getFloorsByType(Floor.FloorType floorType) {
        TypedQuery<Floor> query = entityManager.createQuery("SELECT f FROM Floor f WHERE f.floorType = :floorType", Floor.class);
        query.setParameter("floorType", floorType);
        return query.getResultList();
    }

    public List<Floor> getFloorsByArchCode(String archCode) {
        TypedQuery<Floor> query = entityManager.createQuery("SELECT f FROM Floor f WHERE f.archCode = :archCode", Floor.class);
        query.setParameter("archCode", archCode);
        return query.getResultList();
    }
}