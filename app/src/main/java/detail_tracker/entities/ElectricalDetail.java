package detail_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "electrical_detail")
public class ElectricalDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "electrical_det_id", nullable = false)
    private int electricalDetId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    @Column(name = "location", nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "electrical_device_id", nullable = false)
    private ElectricalDeviceLkp electricalDevice;

    @Column(name = "brand", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'n/a'")
    private String brand = "n/a";

    @Column(name = "model", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'n/a'")
    private String model = "n/a";

    // getters and setters
    public int getElectricalDetId() {
        return electricalDetId;
    }

    public void setElectricalDetId(int electricalDetId) {
        this.electricalDetId = electricalDetId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ElectricalDeviceLkp getElectricalDevice() {
        return electricalDevice;
    }

    public void setElectricalDevice(ElectricalDeviceLkp electricalDevice) {
        this.electricalDevice = electricalDevice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}