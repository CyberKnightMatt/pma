package us.stallings.pma.api.controllers;

import javax.validation.Valid;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import us.stallings.pma.dao.ProjectRepository;
import us.stallings.pma.entities.Project;

import java.util.List;

@RestController
@RequestMapping("/app-api/employees")
public class ProjectApiController {

    private final ProjectRepository projectRepository;

    public ProjectApiController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") Long id) {
        return projectRepository.findById(id).get();
    }

    @PostMapping(consumes ="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody @Valid Project project) {
        return projectRepository.save(project);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Project update(@RequestBody @Valid Project project) {
        return projectRepository.save(project);
    }

    @PatchMapping(path="/{id}", consumes = "application/json")
    public Project partialUpdate(@PathVariable("id") long id, @RequestBody @Valid Project patchProject) {
        Project pro = projectRepository.findById(id).get();

        if(patchProject.getName() != null) {
            pro.setName(patchProject.getName());
        }
        if(patchProject.getStage() != null) {
            pro.setStage(patchProject.getStage());
        }
        if(patchProject.getDescription() != null) {
            pro.setDescription(patchProject.getDescription());
        }

        return projectRepository.save(pro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        try{
            projectRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            // log error
        }

    }


}
