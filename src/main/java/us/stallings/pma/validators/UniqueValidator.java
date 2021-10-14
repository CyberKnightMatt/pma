package us.stallings.pma.validators;

import org.springframework.beans.factory.annotation.Autowired;
import us.stallings.pma.dao.EmployeeRepository;
import us.stallings.pma.entities.Employee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Employee emp = employeeRepository.findByEmail(value);

        if (emp != null) {
            return false;
        }
        else {
            return true;
        }
    }
}
