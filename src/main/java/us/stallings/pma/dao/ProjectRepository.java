package us.stallings.pma.dao;

import org.springframework.data.repository.CrudRepository;
import us.stallings.pma.entities.Project;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    List<Project> findAll();
}
