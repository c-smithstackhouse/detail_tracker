package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.User;

public interface UserDao {
    User findById(Integer id);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(User user);
}