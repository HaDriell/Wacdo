package fr.hadriel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hadriel.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}