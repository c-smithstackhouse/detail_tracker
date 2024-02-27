package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.Floor;

public interface FloorDao {
    Floor findById(Integer id);
    List<Floor> findAll();
    void save(Floor floor);
    void update(Floor floor);
    void delete(Floor floor);
}