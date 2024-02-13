package detail_tracker.dao;

import detail_tracker.entity.Address;
import java.util.List;

public interface AddressDao {
    Address findById(Integer id);
    List<Address> findAll();
    void save(Address address);
    void update(Address address);
    void delete(Address address);
}