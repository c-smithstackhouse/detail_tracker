package detail_tracker.dao;

import detail_tracker.entity.TrimDetail;
import java.util.List;

public interface TrimDetailDao {
    TrimDetail findById(Integer id);
    List<TrimDetail> findAll();
    void save(TrimDetail trimDetail);
    void update(TrimDetail trimDetail);
    void delete(TrimDetail trimDetail);
}