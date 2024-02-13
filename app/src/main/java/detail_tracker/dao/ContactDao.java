package detail_tracker.dao;

import detail_tracker.entity.Contact;
import java.util.List;

public interface ContactDao {
    Contact findById(Integer id);
    List<Contact> findAll();
    void save(Contact contact);
    void update(Contact contact);
    void delete(Contact contact);
}