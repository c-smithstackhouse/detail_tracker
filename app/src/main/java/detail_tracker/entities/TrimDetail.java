package detail_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "trim_detail")
public class TrimDetail {

    public enum TrimType {
        APRON,
        BACKBAND,
        BASEBOARD,
        BUILT_IN,
        COUNTERTOP,
        DOOR_CASING,
        MANTLE,
        PEDESTAL,
        SILL,
        SHELF,
        THRESHOLD,
        WINDOW_CASING,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trim_det_id")
    private int trimDetId;

    @Enumerated(EnumType.STRING)
    @Column(name = "trim_type")
    private TrimType trimType;

    @Column(name = "room_id", nullable = false)
    private int roomId;

    @Column(name = "note_id", nullable = true)
    private int noteId;

    @Column(name = "location", nullable = false, length = 500)
    private String location;

    @Column(name = "material", nullable = false, length = 100)
    private String material;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand;
    
    @Column(name = "type", nullable = false, length = 100)
    private String type;

    // getters and setters
    public int getTrimDetId() {
        return trimDetId;
    }

    public void setTrimDetId(int trimDetId) {
        this.trimDetId = trimDetId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public TrimType getTrimType() {
        return trimType;
    }

    public void setTrimType(TrimType trimType) {
        this.trimType = trimType;
    }
}