package fr.hadriel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.hadriel.entities.Employee;
import fr.hadriel.repos.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        if (employee.getId() != 0) {
            throw new RuntimeException();
        }
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee) {
        employeeRepository.findById(employee.getId()).orElseThrow();
        return employeeRepository.save(employee);
    }

    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> find(long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> all() {
        return employeeRepository.findAll();
    }
}
