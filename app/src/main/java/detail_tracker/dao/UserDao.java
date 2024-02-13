package detail_tracker.dao;

import detail_tracker.entity.User;
import java.util.List;

public interface UserDao {
    User findById(Integer id);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(User user);
}