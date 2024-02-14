package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import detail_tracker.entity.Contact;
import detail_tracker.entity.Contact.Preferred;
import java.util.List;

public class ContactService {

    @PersistenceContext
    private EntityManager entityManager;

    public Contact createContact(String mobile, String landLine, String email, Preferred preferred) {
        Contact contact = new Contact();
        contact.setMobile(mobile);
        contact.setLandLine(landLine);
        contact.setEmail(email);
        contact.setPreferred(preferred);

        entityManager.persist(contact);

        return contact;
    }

    public Contact getContact(Integer contactId) {
        return entityManager.find(Contact.class, contactId);
    }

    public Contact updateContact(Integer contactId, String mobile, String landLine, String email, Preferred preferred) {
        Contact contact = entityManager.find(Contact.class, contactId);
        if (contact != null) {
            contact.setMobile(mobile);
            contact.setLandLine(landLine);
            contact.setEmail(email);
            contact.setPreferred(preferred);
        }

        return contact;
    }

    public void deleteContact(Integer contactId) {
        Contact contact = entityManager.find(Contact.class, contactId);
        if (contact != null) {
            entityManager.remove(contact);
        }
    }

    public List<Contact> getAllContacts() {
        TypedQuery<Contact> query = entityManager.createQuery("SELECT c FROM Contact c", Contact.class);
        return query.getResultList();
    }

    // Additional methods

    public List<Contact> findByPreferred(Preferred preferred) {
        TypedQuery<Contact> query = entityManager.createQuery("SELECT c FROM Contact c WHERE c.preferred = :preferred", Contact.class);
        query.setParameter("preferred", preferred);
        return query.getResultList();
    }

    public List<Contact> findByEmail(String email) {
        TypedQuery<Contact> query = entityManager.createQuery("SELECT c FROM Contact c WHERE c.email = :email", Contact.class);
        query.setParameter("email", email);
        return query.getResultList();
    }
}