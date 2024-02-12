package detail_tracker.keys;

import java.io.Serializable;
import java.util.Objects;

public class ProjectAddressId implements Serializable {

    private Integer projectId;
    private Integer addressId;

    public ProjectAddressId() {}

    public ProjectAddressId(Integer projectId, Integer addressId) {
        this.projectId = projectId;
        this.addressId = addressId;
    }

    // getters and setters

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectAddressId that = (ProjectAddressId) o;
        return Objects.equals(projectId, that.projectId) &&
                Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, addressId);
    }
}