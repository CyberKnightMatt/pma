package us.stallings.pma.dao;

import org.springframework.data.repository.CrudRepository;
import us.stallings.pma.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    List<Employee> findAll();
}
