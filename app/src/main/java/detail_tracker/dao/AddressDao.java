package detail_tracker.dao;

import detail_tracker.entity.Address;
import java.util.List;

public interface AddressDao {
    Address getAddress(Integer id);
    List<Address> getAllAddresses();
    void saveAddress(Address address);
    void deleteAddress(Integer id);
}