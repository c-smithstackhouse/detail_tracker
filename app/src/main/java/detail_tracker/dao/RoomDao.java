package detail_tracker.dao;

import detail_tracker.entity.Room;
import java.util.List;

public interface RoomDao {
    Room findById(Integer id);
    List<Room> findAll();
    void save(Room room);
    void update(Room room);
    void delete(Room room);
}
