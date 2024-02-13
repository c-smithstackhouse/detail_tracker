package detail_tracker.dao;

import detail_tracker.entity.FlooringDetail;
import java.util.List;

public interface FlooringDetailDao {
    FlooringDetail findById(Integer id);
    List<FlooringDetail> findAll();
    void save(FlooringDetail flooringDetail);
    void update(FlooringDetail flooringDetail);
    void delete(FlooringDetail flooringDetail);
}