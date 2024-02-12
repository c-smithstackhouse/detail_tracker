package detail_tracker.dao;

import detail_tracker.entity.User;
import java.util.List;

public interface UserDao {
    User getUser(Integer id);
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(Integer id);
}