package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.FlooringDetail;

public interface FlooringDetailDao {
    FlooringDetail findById(Integer id);
    List<FlooringDetail> findAll();
    void save(FlooringDetail flooringDetail);
    void update(FlooringDetail flooringDetail);
    void delete(FlooringDetail flooringDetail);
}