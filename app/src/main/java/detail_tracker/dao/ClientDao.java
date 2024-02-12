package detail_tracker.dao;

import detail_tracker.entity.Client;
import java.util.List;

public interface ClientDao {
    Client getClient(Integer id);
    List<Client> getAllClients();
    void saveClient(Client client);
    void deleteClient(Integer id);
}