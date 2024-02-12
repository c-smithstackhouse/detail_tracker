package detail_tracker.dao;

import detail_tracker.entity.Project;
import java.util.List;

public interface ProjectDao {
    Project getProject(Integer id);
    List<Project> getAllProjects();
    void saveProject(Project project);
    void deleteProject(Integer id);
}