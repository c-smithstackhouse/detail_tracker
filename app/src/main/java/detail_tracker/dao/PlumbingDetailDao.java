package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.PlumbingDetail;

public interface PlumbingDetailDao {
    PlumbingDetail findById(Integer id);
    List<PlumbingDetail> findAll();
    void save(PlumbingDetail plumbingDetail);
    void update(PlumbingDetail plumbingDetail);
    void delete(PlumbingDetail plumbingDetail);
}