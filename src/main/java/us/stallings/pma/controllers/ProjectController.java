package us.stallings.pma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import us.stallings.pma.entities.Project;

@Controller
@RequestMapping(value="/projects")
public class ProjectController {

    @GetMapping("/new")
     public String displayProjectForm(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        return "new-projects";
    }

    @PostMapping(value="/save")
    public String createProject(Project project, Model model) {
        // this should hanle saving to the database....
        return "";
    }
}
