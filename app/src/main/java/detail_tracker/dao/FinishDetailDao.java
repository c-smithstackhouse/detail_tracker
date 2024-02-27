package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.FinishDetail;

public interface FinishDetailDao {
    FinishDetail findById(Integer id);
    List<FinishDetail> findAll();
    void save(FinishDetail finishDetail);
    void update(FinishDetail finishDetail);
    void delete(FinishDetail finishDetail);
}