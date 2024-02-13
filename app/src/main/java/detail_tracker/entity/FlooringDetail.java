package detail_tracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "finish_details")
public class FlooringDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flooring_det_id", nullable = false)
    private int flooringDetId;

    @Column(name = "room_id", nullable = false)
    private int roomId;

    @Column(name = "note_id", nullable = false)
    private int noteId;

    @Column(name = "material", nullable = false, length = 100)
    private String material;

    @Column(name = "dimensions", nullable = false, length = 100)
    private String dimensions;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand = "n/a";

    // getters and setters
    public int getFlooringDetId() {
        return flooringDetId;
    }

    public void setFlooringDetId(int flooringDetId) {
        this.flooringDetId = flooringDetId;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
