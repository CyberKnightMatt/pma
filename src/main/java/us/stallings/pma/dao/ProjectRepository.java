package us.stallings.pma.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import us.stallings.pma.dto.ChartData;
import us.stallings.pma.entities.Project;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    @Override
    List<Project> findAll();

    @Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value " +
            "FROM project " + "" +
            "GROUP BY stage")
    List<ChartData> getProjectStatus();

}
