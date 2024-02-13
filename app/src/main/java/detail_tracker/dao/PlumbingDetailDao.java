package detail_tracker.dao;

import detail_tracker.entity.PlumbingDetail;
import java.util.List;

public interface PlumbingDetailDao {
    PlumbingDetail findById(Integer id);
    List<PlumbingDetail> findAll();
    void save(PlumbingDetail plumbingDetail);
    void update(PlumbingDetail plumbingDetail);
    void delete(PlumbingDetail plumbingDetail);
}