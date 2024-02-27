package detail_tracker.dao.impl;

import detail_tracker.dao.ClientDao;
import detail_tracker.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client findById(Integer id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    @Override
    public void save(Client client) {
        entityManager.persist(client);
    }

    @Override
    public void update(Client client) {
        entityManager.merge(client);
    }

    @Override
    public void delete(Client client) {
        entityManager.remove(entityManager.contains(client) ? client : entityManager.merge(client));
    }
}