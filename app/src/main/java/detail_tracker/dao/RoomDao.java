package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.Room;

public interface RoomDao {
    Room findById(Integer id);
    List<Room> findAll();
    void save(Room room);
    void update(Room room);
    void delete(Room room);
}
