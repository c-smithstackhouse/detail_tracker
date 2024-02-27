package detail_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "electrical_device_lkp")
public class ElectricalDeviceLkp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "electrical_device_id", nullable = false)
    private int electricalDeviceId;

    @Column(name = "electrical_device", nullable = false)
    private String electricalDevice;

    // getters and setters
    public int getElectricalDeviceId() {
        return electricalDeviceId;
    }

    public void setElectricalDeviceId(int electricalDeviceId) {
        this.electricalDeviceId = electricalDeviceId;
    }

    public String getElectricalDevice() {
        return electricalDevice;
    }

    public void setElectricalDevice(String electricalDevice) {
        this.electricalDevice = electricalDevice;
    }
}