package detail_tracker.dao.impl;

import detail_tracker.dao.ContactDao;
import detail_tracker.entity.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class ContactDaoImpl implements ContactDao {
    private SessionFactory sessionFactory;

    public ContactDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Contact getContact(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Contact.class, id);
        }
    }

    @Override
    public List<Contact> getAllContacts() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Contact", Contact.class).list();
        }
    }

    @Override
    public void saveContact(Contact contact) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(contact);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContact(Integer id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Contact contact = session.get(Contact.class, id);
            if (contact != null) {
                session.remove(contact);
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