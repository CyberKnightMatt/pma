package us.stallings.pma.dao;

import org.springframework.data.repository.CrudRepository;
import us.stallings.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
