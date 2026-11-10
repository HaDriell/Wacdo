package fr.hadriel.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hadriel.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}