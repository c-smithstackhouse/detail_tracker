package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

import detail_tracker.entities.Address;
import detail_tracker.entities.Address.State;

public class AddressService {

    @PersistenceContext
    private EntityManager entityManager;

    public Address createAddress(String address1, String address2, String city, State state, String zip) {
        Address address = new Address();
        address.setAddress1(address1);
        address.setAddress2(address2);
        address.setCity(city);
        address.setState(state);
        address.setZip(zip);

        entityManager.persist(address);

        return address;
    }

    public Address getAddress(Integer addressId) {
        return entityManager.find(Address.class, addressId);
    }

    public Address updateAddress(Integer addressId, String address1, String address2, String city, State state, String zip) {
        Address address = entityManager.find(Address.class, addressId);
        if (address != null) {
            address.setAddress1(address1);
            address.setAddress2(address2);
            address.setCity(city);
            address.setState(state);
            address.setZip(zip);
        }

        return address;
    }

    public void deleteAddress(Integer addressId) {
        Address address = entityManager.find(Address.class, addressId);
        if (address != null) {
            entityManager.remove(address);
        }
    }

    public List<Address> getAllAddresses() {
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a", Address.class);
        return query.getResultList();
    }

    // Additional methods

    public List<Address> findByCity(String city) {
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a WHERE a.city = :city", Address.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    public List<Address> findByState(State state) {
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a WHERE a.state = :state", Address.class);
        query.setParameter("state", state);
        return query.getResultList();
    }
}