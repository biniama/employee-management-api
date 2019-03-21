package tech.biniam.employeemanagementapi.repos;

import org.springframework.data.repository.CrudRepository;
import tech.biniam.employeemanagementapi.domains.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
