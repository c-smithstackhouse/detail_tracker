package detail_tracker.dao;

import detail_tracker.entity.Contact;
import java.util.List;

public interface ContactDao {
    Contact getContact(Integer id);
    List<Contact> getAllContacts();
    void saveContact(Contact contact);
    void deleteContact(Integer id);
}