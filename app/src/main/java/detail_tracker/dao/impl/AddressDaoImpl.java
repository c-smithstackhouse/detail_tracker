package detail_tracker.dao.impl;

import detail_tracker.dao.AddressDao;
import detail_tracker.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    private SessionFactory sessionFactory;

    public AddressDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Address getAddress(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Address.class, id);
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Address", Address.class).list();
        }
    }

    @Override
    public void saveAddress(Address address) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(address);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAddress(Integer id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Address address = session.get(Address.class, id);
            if (address != null) {
                session.remove(address);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}