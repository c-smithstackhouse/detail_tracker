package detail_tracker.dao;

import detail_tracker.entity.FinishDetail;
import java.util.List;

public interface FinishDetailDao {
    FinishDetail findById(Integer id);
    List<FinishDetail> findAll();
    void save(FinishDetail finishDetail);
    void update(FinishDetail finishDetail);
    void delete(FinishDetail finishDetail);
}