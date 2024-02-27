package detail_tracker.entities;

import java.io.Serializable;
import java.util.Objects;

public class ProjectClientId implements Serializable{
    private int project;
    private int client;

    public ProjectClientId() {
    }

    public ProjectClientId(int project, int client) {
        this.project = project;
        this.client = client;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectClientId)) return false;
        ProjectClientId that = (ProjectClientId) o;
        return getProject() == that.getProject() && getClient() == that.getClient();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProject(), getClient());
    }
}
