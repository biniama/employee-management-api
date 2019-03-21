package tech.biniam.employeemanagementapi.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String description;
}

