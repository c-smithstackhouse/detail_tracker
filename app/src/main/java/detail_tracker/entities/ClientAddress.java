package detail_tracker.entities;

import detail_tracker.keys.ClientAddressId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "client_address")
@IdClass(ClientAddressId.class)
public class ClientAddress {

    @Id
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    @Id
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address addressId;

    public Client getClient() {
        return clientId;
    }

    public void setClient(Client clientId) {
        this.clientId = clientId;
    }

    public Address getAddress() {
        return addressId;
    }

    public void setAddress(Address addressId) {
        this.addressId = addressId;
    }
}