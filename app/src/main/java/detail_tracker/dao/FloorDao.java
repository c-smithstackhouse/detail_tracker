package detail_tracker.dao;

import detail_tracker.entity.Floor;
import java.util.List;

public interface FloorDao {
    Floor getFloor(Integer id);
    List<Floor> getAllFloors();
    void saveFloor(Floor floor);
    void deleteFloor(Integer id);
}