package detail_tracker.keys;

import java.io.Serializable;
import java.util.Objects;

public class ClientAddressId implements Serializable {

    private Integer clientId;
    private Integer addressId;

    public ClientAddressId() {}

    public ClientAddressId(Integer clientId, Integer addressId) {
        this.clientId = clientId;
        this.addressId = addressId;
    }

    // getters and setters

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientAddressId that = (ClientAddressId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, addressId);
    }
}