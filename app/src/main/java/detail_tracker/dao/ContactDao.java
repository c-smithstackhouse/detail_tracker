package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.Contact;

public interface ContactDao {
    Contact findById(Integer id);
    List<Contact> findAll();
    void save(Contact contact);
    void update(Contact contact);
    void delete(Contact contact);
}