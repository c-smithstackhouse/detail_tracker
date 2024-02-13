package detail_tracker.dao.impl;

import detail_tracker.dao.ProjectDao;
import detail_tracker.entity.Project;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ProjectDaoImpl implements ProjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Project findById(Integer id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public List<Project> findAll() {
        return entityManager.createQuery("SELECT p FROM Project p", Project.class).getResultList();
    }

    @Override
    public void save(Project project) {
        entityManager.persist(project);
    }

    @Override
    public void update(Project project) {
        entityManager.merge(project);
    }

    @Override
    public void delete(Project project) {
        entityManager.remove(entityManager.contains(project) ? project : entityManager.merge(project));
    }
}