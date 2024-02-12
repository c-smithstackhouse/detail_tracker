package detail_tracker.keys;

import java.io.Serializable;
import java.util.Objects;

public class UserContactId implements Serializable {

    private Integer userId;
    private Integer contactId;

    public UserContactId() {}

    public UserContactId(Integer userId, Integer contactId) {
        this.userId = userId;
        this.contactId = contactId;
    }

    // getters and setters

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        UserContactId that = (UserContactId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(contactId, that.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, contactId);
    }
}