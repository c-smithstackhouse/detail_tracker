package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

import detail_tracker.entities.Contact;
import detail_tracker.entities.User;

public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    public User createUser(Contact contact, String username, String userFirstName, String userLastName, String hashedPass, String salt, User.JobTitle jobTitle, Boolean editPrivileges) {
        User user = new User();
        user.setContact(contact);
        user.setUsername(username);
        user.setUserFirstName(userFirstName);
        user.setUserLastName(userLastName);
        user.setHashedPass(hashedPass);
        user.setSalt(salt);
        user.setJobTitle(jobTitle);
        user.setEditPrivileges(editPrivileges);

        entityManager.persist(user);

        return user;
    }

    public User getUser(Integer userId) {
        return entityManager.find(User.class, userId);
    }

    public User updateUser(Integer userId, Contact contact, String username, String userFirstName, String userLastName, String hashedPass, String salt, User.JobTitle jobTitle, Boolean editPrivileges) {
        User user = entityManager.find(User.class, userId);
        if (user != null) {
            user.setContact(contact);
            user.setUsername(username);
            user.setUserFirstName(userFirstName);
            user.setUserLastName(userLastName);
            user.setHashedPass(hashedPass);
            user.setSalt(salt);
            user.setJobTitle(jobTitle);
            user.setEditPrivileges(editPrivileges);
        }

        return user;
    }

    public void deleteUser(Integer userId) {
        User user = entityManager.find(User.class, userId);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    // More methods below...
        public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public User findByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

    public List<User> findByJobTitle(User.JobTitle jobTitle) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.jobTitle = :jobTitle", User.class);
        query.setParameter("jobTitle", jobTitle);
        return query.getResultList();
    }

    public boolean hasEditPrivileges(Integer userId) {
        User user = getUser(userId);
        return user != null && user.getEditPrivileges();
    }

    /* 
    public User updatePassword(Integer userId, String hashedPass, String salt) {
        User user = getUser(userId);
        if (user != null) {
            user.setHashedPass(hashedPass);
            user.setSalt(salt);
        }
        return user;
    }
    */

}