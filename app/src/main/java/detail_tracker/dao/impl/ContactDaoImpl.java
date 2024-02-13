package detail_tracker.dao.impl;

import detail_tracker.dao.ContactDao;
import detail_tracker.entity.Contact;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class ContactDaoImpl implements ContactDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Contact findById(Integer id) {
        return entityManager.find(Contact.class, id);
    }

    @Override
    public List<Contact> findAll() {
        return entityManager.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
    }

    @Override
    public void save(Contact contact) {
        entityManager.persist(contact);
    }

    @Override
    public void update(Contact contact) {
        entityManager.merge(contact);
    }

    @Override
    public void delete(Contact contact) {
        entityManager.remove(entityManager.contains(contact) ? contact : entityManager.merge(contact));
    }
}