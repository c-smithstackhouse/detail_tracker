package detail_tracker.dao;

import detail_tracker.entity.Room;
import java.util.List;

public interface RoomDao {
    Room getRoom(Integer id);
    List<Room> getAllRooms();
    void saveRoom(Room room);
    void deleteRoom(Integer id);
}
