package us.stallings.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import us.stallings.pma.ProjectManagementApplication;
import us.stallings.pma.dao.ProjectRepository;
import us.stallings.pma.entities.Project;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes= ProjectManagementApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:import.sql"}),
        @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")})
public class ProjectRepositoryIntegrationTest {
    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void ifNewProjectSaved_thenSucces() {
        Project newProject = new Project("New Test Project", "COMPLETE", "Test Description");
        projectRepository.save(newProject);
        assertEquals(5, projectRepository.findAll().size());
    }

}
