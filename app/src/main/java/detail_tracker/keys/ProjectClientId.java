package detail_tracker.keys;

import java.io.Serializable;
import java.util.Objects;

public class ProjectClientId implements Serializable {

    private Integer projectId;
    private Integer clientId;

    public ProjectClientId() {}

    public ProjectClientId(Integer projectId, Integer clientId) {
        this.projectId = projectId;
        this.clientId = clientId;
    }

    // getters and setters

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectClientId that = (ProjectClientId) o;
        return Objects.equals(projectId, that.projectId) &&
                Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, clientId);
    }
}
