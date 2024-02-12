package detail_tracker.keys;

import java.io.Serializable;
import java.util.Objects;

public class ClientContactId implements Serializable {

    private Integer clientId;
    private Integer contactId;

    public ClientContactId() {}

    public ClientContactId(Integer clientId, Integer contactId) {
        this.clientId = clientId;
        this.contactId = contactId;
    }

    // getters and setters

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientContactId that = (ClientContactId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(contactId, that.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, contactId);
    }
}