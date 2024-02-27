package detail_tracker.entities;

import detail_tracker.keys.ProjectClientId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "project_client")
@IdClass(ProjectClientId.class)
public class ProjectClient {

    @Id
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projectId;

    @Id
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    public Project getProject() {
        return projectId;
    }

    public void setProject(Project projectId) {
        this.projectId = projectId;
    }

    public Client getClient() {
        return clientId;
    }

    public void setClient(Client clientId) {
        this.clientId = clientId;
    }
}