package detail_tracker.dao;

import detail_tracker.entity.Client;
import java.util.List;

public interface ClientDao {
    Client findById(Integer id);
    List<Client> findAll();
    void save(Client client);
    void update(Client client);
    void delete(Client client);
}