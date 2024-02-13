package detail_tracker.dao;

import detail_tracker.entity.ElectricalDetail;
import java.util.List;

public interface ElectricalDetailDao {
    ElectricalDetail findById(Integer id);
    List<ElectricalDetail> findAll();
    void save(ElectricalDetail electricalDetail);
    void update(ElectricalDetail electricalDetail);
    void delete(ElectricalDetail electricalDetail);
}