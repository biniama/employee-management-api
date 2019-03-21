package tech.biniam.employeemanagementapi.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import tech.biniam.employeemanagementapi.domains.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
