package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

import detail_tracker.entities.Floor;
import detail_tracker.entities.Room;
import detail_tracker.entities.Room.RoomType;

public class RoomService {

    @PersistenceContext
    private EntityManager entityManager;

    public Room createRoom(Floor floor, RoomType roomType, String roomName, String archCode) {
        Room room = new Room();
        room.setFloor(floor);
        room.setRoomType(roomType);
        room.setRoomName(roomName);
        room.setArchCode(archCode);

        entityManager.persist(room);

        return room;
    }

    public Room getRoom(int roomId) {
        return entityManager.find(Room.class, roomId);
    }

    public Room updateRoom(int roomId, Floor floor, RoomType roomType, String roomName, String archCode) {
        Room room = entityManager.find(Room.class, roomId);
        if (room != null) {
            room.setFloor(floor);
            room.setRoomType(roomType);
            room.setRoomName(roomName);
            room.setArchCode(archCode);
        }

        return room;
    }

    public void deleteRoom(int roomId) {
        Room room = entityManager.find(Room.class, roomId);
        if (room != null) {
            entityManager.remove(room);
        }
    }

    public List<Room> getAllRooms() {
        TypedQuery<Room> query = entityManager.createQuery("SELECT r FROM Room r", Room.class);
        return query.getResultList();
    }

    public List<Room> getRoomsByFloor(Floor floor) {
        TypedQuery<Room> query = entityManager.createQuery("SELECT r FROM Room r WHERE r.floor = :floor", Room.class);
        query.setParameter("floor", floor);
        return query.getResultList();
    }

    public List<Room> getRoomsByRoomType(RoomType roomType) {
        TypedQuery<Room> query = entityManager.createQuery("SELECT r FROM Room r WHERE r.roomType = :roomType", Room.class);
        query.setParameter("roomType", roomType);
        return query.getResultList();
    }
}
