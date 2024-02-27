package detail_tracker.entities;

import java.io.Serializable;
import java.util.Objects;

public class ClientAddressId implements Serializable{
    private int client;
    private int address;

    public ClientAddressId() {
    }

    public ClientAddressId(int client, int address) {
        this.client = client;
        this.address = address;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientAddressId)) return false;
        ClientAddressId that = (ClientAddressId) o;
        return getClient() == that.getClient() && getAddress() == that.getAddress();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClient(), getAddress());
    }
    
}
