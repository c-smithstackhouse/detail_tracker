package detail_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "trim_type_lkp")
public class TrimTypeLkp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    public TrimTypeLkp() {
    }

    public TrimTypeLkp(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}