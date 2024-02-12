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
@Table(name = "Floor")
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

    /**     
    @Column(name = "floor_name", nullable = false, length = 100, columnDefinition = "varchar(100) default 'n/a'")
    private String floorName = "n/a";
    */

    @Column(name = "arch_code", nullable = false, length = 20, columnDefinition = "varchar(20) default 'n/a'")
    private String archCode = "n/a";

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
    /**
    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }
    */

    public String getArchCode() {
        return archCode;
    }

    public void setArchCode(String archCode) {
        this.archCode = archCode;
    }
}