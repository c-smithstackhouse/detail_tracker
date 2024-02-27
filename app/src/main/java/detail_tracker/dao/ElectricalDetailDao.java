package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.ElectricalDetail;

public interface ElectricalDetailDao {
    ElectricalDetail findById(Integer id);
    List<ElectricalDetail> findAll();
    void save(ElectricalDetail electricalDetail);
    void update(ElectricalDetail electricalDetail);
    void delete(ElectricalDetail electricalDetail);
}