package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import detail_tracker.entity.Client;
import detail_tracker.entity.Contact;
import java.util.List;

public class ClientService {

    @PersistenceContext
    private EntityManager entityManager;

    public Client createClient(Contact contact, String clientFirstName, String clientLastName) {
        Client client = new Client();
        client.setContact(contact);
        client.setClientFirstName(clientFirstName);
        client.setClientLastName(clientLastName);

        entityManager.persist(client);

        return client;
    }

    public Client getClient(Integer clientId) {
        return entityManager.find(Client.class, clientId);
    }

    public Client updateClient(Integer clientId, Contact contact, String clientFirstName, String clientLastName) {
        Client client = entityManager.find(Client.class, clientId);
        if (client != null) {
            client.setContact(contact);
            client.setClientFirstName(clientFirstName);
            client.setClientLastName(clientLastName);
        }

        return client;
    }

    public void deleteClient(Integer clientId) {
        Client client = entityManager.find(Client.class, clientId);
        if (client != null) {
            entityManager.remove(client);
        }
    }

    public List<Client> getAllClients() {
        TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }

    public List<Client> findByFirstName(String clientFirstName) {
        TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c WHERE c.clientFirstName = :clientFirstName", Client.class);
        query.setParameter("clientFirstName", clientFirstName);
        return query.getResultList();
    }

    public List<Client> findByLastName(String clientLastName) {
        TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c WHERE c.clientLastName = :clientLastName", Client.class);
        query.setParameter("clientLastName", clientLastName);
        return query.getResultList();
    }

    public Client updateContact(Integer clientId, Contact contact) {
        Client client = getClient(clientId);
        if (client != null) {
            client.setContact(contact);
        }
        return client;
    }

}