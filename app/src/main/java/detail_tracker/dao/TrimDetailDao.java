package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.TrimDetail;

public interface TrimDetailDao {
    TrimDetail findById(Integer id);
    List<TrimDetail> findAll();
    void save(TrimDetail trimDetail);
    void update(TrimDetail trimDetail);
    void delete(TrimDetail trimDetail);
}