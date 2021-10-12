package us.stallings.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import us.stallings.pma.dao.EmployeeRepository;
import us.stallings.pma.dao.ProjectRepository;
import us.stallings.pma.dto.ChartData;
import us.stallings.pma.dto.EmployeeProject;
import us.stallings.pma.entities.Project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        // we are querying the database for projects
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects",projects);

        List<ChartData> projectData = projectRepository.getProjectStatus();
        // Convert projetDat object into a json structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);

        model.addAttribute("projectStatusCnt", jsonString);

        // we are querying the database for employees
        List<EmployeeProject> employeeList = employeeRepository.employeeProjects();
        model.addAttribute("employeesList",employeeList);
        return "main/home";
    }
}
