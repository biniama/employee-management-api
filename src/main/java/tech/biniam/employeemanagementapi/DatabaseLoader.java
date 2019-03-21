package tech.biniam.employeemanagementapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.biniam.employeemanagementapi.domains.Employee;
import tech.biniam.employeemanagementapi.repos.EmployeeRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DatabaseLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
      this.employeeRepository.save(Employee.builder()
              .firstName("Biniam")
              .lastName("Asnake")
              .description("Software Engineer")
              .build());
    }
}
