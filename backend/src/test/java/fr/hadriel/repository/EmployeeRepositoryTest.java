package fr.hadriel.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import fr.hadriel.model.Employee;
import fr.hadriel.repositories.EmployeeRepository;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired 
    private EmployeeRepository repository;

    @Test 
    void shouldCreateEmployee() {
        var now = LocalDate.now();
        var firstname = "John";
        var lastname = "Doe";
        var password = "Secret";

        var employee = new Employee();
        employee.setAdministrator(true);
        employee.setDateOfHire(now);
        employee.setFirstName(firstname);
        employee.setLastName(lastname);
        employee.setPassword(password);

        employee = repository.save(employee);
        employee = repository.findById(employee.getId()).orElseThrow();

        assertNotEquals(0, employee.getId());
        assertEquals(now, employee.getDateOfHire());
        assertEquals(firstname, employee.getFirstName());
        assertEquals(lastname, employee.getLastName());
        assertEquals(password, employee.getPassword());
    }

    @Test
    void shouldUpdateEmployee() {
        var now = LocalDate.now();
        var firstname = "John";
        var lastname = "Doe";
        var password = "Secret";

        var employeeToCreate = new Employee();
        employeeToCreate.setAdministrator(true);
        employeeToCreate.setDateOfHire(now);
        employeeToCreate.setFirstName(firstname);
        employeeToCreate.setLastName(lastname);
        employeeToCreate.setPassword(password);

        var newLastname = "Carmack";

        var createdEmployee = repository.save(employeeToCreate);
        createdEmployee.setLastName(newLastname);
        var updatedEmployee = repository.save(createdEmployee);

        assertEquals(createdEmployee.getId(), updatedEmployee.getId());
        assertEquals(newLastname, updatedEmployee.getLastName());
        assertEquals(createdEmployee, updatedEmployee);
    }

}
