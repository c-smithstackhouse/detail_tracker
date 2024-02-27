package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.Client;

public interface ClientDao {
    Client findById(Integer id);
    List<Client> findAll();
    void save(Client client);
    void update(Client client);
    void delete(Client client);
}