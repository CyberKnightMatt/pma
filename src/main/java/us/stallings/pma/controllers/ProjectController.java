package us.stallings.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import us.stallings.pma.dao.ProjectRepository;
import us.stallings.pma.entities.Employee;
import us.stallings.pma.entities.Project;

import java.util.List;

@Controller
@RequestMapping(value="/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
     public String displayProjectForm(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        return "projects/new-projects";
    }

    @PostMapping(value="/save")
    public String createProject(Project project, Model model) {
        projectRepository.save(project);

        // user a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
