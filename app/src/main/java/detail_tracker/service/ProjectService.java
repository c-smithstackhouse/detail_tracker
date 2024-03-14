package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.NonUniqueResultException;

import java.util.List;

import detail_tracker.entities.Project;

public class ProjectService {

    @PersistenceContext
    private EntityManager entityManager;

        private EntityManagerFactory entityManagerFactory;

    public ProjectService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("your_persistence_unit");
    }

    public List<String> getActiveProjects() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            String queryStr = "SELECT p.project_name FROM Project p WHERE p.archived = false";
            TypedQuery<String> query = entityManager.createQuery(queryStr, String.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<String> getArchivedProjects() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    
        try {
            String queryStr = "SELECT p.project_name FROM Project p WHERE p.archived = true";
            TypedQuery<String> query = entityManager.createQuery(queryStr, String.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

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
public Project getProjectByName(String projectName) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    try {
        String queryStr = "SELECT p FROM Project p WHERE p.project_name = :name";
        TypedQuery<Project> query = entityManager.createQuery(queryStr, Project.class);
        query.setParameter("name", projectName);
        return query.getSingleResult();
    } catch (NoResultException e) {
        // No project with the given name was found
        return null;
    } catch (NonUniqueResultException e) {
        // More than one project with the given name was found
        // Handle this case as needed
        return null;
    } finally {
        entityManager.close();
    }
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