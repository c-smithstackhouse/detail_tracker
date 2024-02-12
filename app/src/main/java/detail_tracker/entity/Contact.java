package detail_tracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "Contact")
public class Contact {

    public enum Preferred {
        MOBILE, LANDLINE, EMAIL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id", nullable = false, unique = true)
    private Integer contactId;

    @Column(name = "mobile", nullable = false, length = 15, columnDefinition = "varchar(15) default 'n/a'")
    private String mobile;

    @Column(name = "land_line", nullable = false, length = 15, columnDefinition = "varchar(15) default 'n/a'")
    private String landLine;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "preferred", nullable = false)
    private Preferred preferred;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Preferred getPreferred() {
        return preferred;
    }

    public void setPreferred(Preferred preferred) {
        this.preferred = preferred;
    }
}
