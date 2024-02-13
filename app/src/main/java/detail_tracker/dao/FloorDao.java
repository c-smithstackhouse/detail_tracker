package detail_tracker.dao;

import detail_tracker.entity.Floor;
import java.util.List;

public interface FloorDao {
    Floor findById(Integer id);
    List<Floor> findAll();
    void save(Floor floor);
    void update(Floor floor);
    void delete(Floor floor);
}