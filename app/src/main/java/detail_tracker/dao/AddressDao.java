package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.Address;

public interface AddressDao {
    Address findById(Integer id);
    List<Address> findAll();
    void save(Address address);
    void update(Address address);
    void delete(Address address);
}