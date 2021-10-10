package us.stallings.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import us.stallings.pma.dao.EmployeeRepository;
import us.stallings.pma.dao.ProjectRepository;
import us.stallings.pma.entities.Employee;
import us.stallings.pma.entities.Project;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) {
        return "main/home";
    }
}
