package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import detail_tracker.entity.Project;
import java.util.List;

public class ProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public Project createProject(String projectName, Boolean archived) {
        Project project = new Project();
        project.setProjectName(projectName);
        project.setArchived(archived);

        entityManager.persist(project);

        return project;
    }

    public Project getProject(Integer projectId) {
        return entityManager.find(Project.class, projectId);
    }

    public Project updateProject(Integer projectId, String projectName, Boolean archived) {
        Project project = entityManager.find(Project.class, projectId);
        if (project != null) {
            project.setProjectName(projectName);
            project.setArchived(archived);
        }

        return project;
    }

    public void deleteProject(Integer projectId) {
        Project project = entityManager.find(Project.class, projectId);
        if (project != null) {
            entityManager.remove(project);
        }
    }

    public List<Project> getAllProjects() {
        TypedQuery<Project> query = entityManager.createQuery("SELECT p FROM Project p", Project.class);
        return query.getResultList();
    }

    // Additional methods

    public List<Project> findByProjectName(String projectName) {
        TypedQuery<Project> query = entityManager.createQuery("SELECT p FROM Project p WHERE p.projectName = :projectName", Project.class);
        query.setParameter("projectName", projectName);
        return query.getResultList();
    }

    public List<Project> findArchivedProjects() {
        TypedQuery<Project> query = entityManager.createQuery("SELECT p FROM Project p WHERE p.archived = true", Project.class);
        return query.getResultList();
    }

    public Project archiveProject(Integer projectId) {
        Project project = getProject(projectId);
        if (project != null) {
            project.setArchived(true);
        }
        return project;
    }
}