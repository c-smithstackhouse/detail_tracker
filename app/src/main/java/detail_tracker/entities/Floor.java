package detail_tracker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.util.Set;

@Entity
@Table(name = "floor")
public class Floor {

    public enum FloorType {
        BASEMENT,
        FIRST_FLOOR,
        SECOND_FLOOR,
        THIRD_FLOOR,
        FOURTH_FLOOR,
        ATTIC
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "floor_id", nullable = false, unique = true)
    private Integer floorId;

    @Enumerated(EnumType.STRING)
    @Column(name = "floor_type", nullable = false)
    private FloorType floorType;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "room_cnt", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer roomCount = 1;

    @OneToMany(mappedBy = "floor")
    private Set<Room> rooms;

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public FloorType getFloorType() {
        return floorType;
    }

    public void setFloorType(FloorType floorType) {
        this.floorType = floorType;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

}