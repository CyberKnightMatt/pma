package us.stallings.pma.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import us.stallings.pma.dto.ChartData;
import us.stallings.pma.entities.Project;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "apiprojects", path="apiprojects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    @Override
    List<Project> findAll();

    @Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value " +
            "FROM project " + "" +
            "GROUP BY stage")
    List<ChartData> getProjectStatus();

}
