package us.stallings.pma.api.controllers;

import javax.validation.Valid;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import us.stallings.pma.dao.EmployeeRepository;
import us.stallings.pma.entities.Employee;

import java.util.List;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

    private final EmployeeRepository employeeRepository;

    public EmployeeApiController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeRepository.findById(id).get();
    }

    @PostMapping(consumes ="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody @Valid Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody @Valid Employee employee) {
        return employeeRepository.save(employee);
    }

    @PatchMapping(path="/{id}", consumes = "application/json")
    public Employee partialUpdate(@PathVariable("id") long id, @RequestBody @Valid Employee patchEmployee) {
        Employee emp = employeeRepository.findById(id).get();

        if(patchEmployee.getEmail() != null) {
            emp.setEmail(patchEmployee.getEmail());
        }
        if(patchEmployee.getFirstName() != null) {
            emp.setFirstName(patchEmployee.getFirstName());
        }
        if(patchEmployee.getLastName() != null) {
            emp.setLastName(patchEmployee.getLastName());
        }

        return employeeRepository.save(emp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        try{
            employeeRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            // log error
        }

    }


}
