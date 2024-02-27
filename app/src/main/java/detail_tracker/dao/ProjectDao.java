package detail_tracker.dao;

import java.util.List;

import detail_tracker.entities.Project;

public interface ProjectDao {
    Project findById(Integer id);
    List<Project> findAll();
    void save(Project project);
    void update(Project project);
    void delete(Project project);
}