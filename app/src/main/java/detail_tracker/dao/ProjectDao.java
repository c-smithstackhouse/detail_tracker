package detail_tracker.dao;

import detail_tracker.entity.Project;
import java.util.List;

public interface ProjectDao {
    Project findById(Integer id);
    List<Project> findAll();
    void save(Project project);
    void update(Project project);
    void delete(Project project);
}