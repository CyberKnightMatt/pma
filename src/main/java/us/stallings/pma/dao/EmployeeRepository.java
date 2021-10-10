package us.stallings.pma.dao;

import org.springframework.data.repository.CrudRepository;
import us.stallings.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
