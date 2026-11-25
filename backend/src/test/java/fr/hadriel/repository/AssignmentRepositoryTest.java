package fr.hadriel.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import fr.hadriel.model.Assignment;
import fr.hadriel.model.Employee;
import fr.hadriel.model.Function;
import fr.hadriel.model.Restaurant;
import fr.hadriel.repositories.AssignmentRepository;
import fr.hadriel.repositories.EmployeeRepository;
import fr.hadriel.repositories.FunctionRepository;
import fr.hadriel.repositories.RestaurantRepository;

@DataJpaTest
public class AssignmentRepositoryTest {

    @Autowired 
    private AssignmentRepository assignmentRepository;
    @Autowired 
    private EmployeeRepository employeeRepository;
    @Autowired 
    private RestaurantRepository restaurantRepository;
    @Autowired 
    private FunctionRepository functionRepository;

    private Restaurant makeRestaurant(String name) {
        var restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setStreet("Street");
        restaurant.setCity("City");
        restaurant.setState("State");
        restaurant.setZipCode("ZipCode");

        return restaurantRepository.save(restaurant);
    }

    private Employee makeEmployee(String firstname) {
        var employee = new Employee();
        employee.setFirstName(firstname);
        employee.setLastName("Lastname");
        employee.setDateOfHire(LocalDate.now());
        employee.setPassword("secret");
        employee.setAdministrator(false);

        return employeeRepository.save(employee);
    }

    private Function makeFunction(String name) {
        var function = new Function();
        function.setLabel(name);

        return functionRepository.save(function);
    }

    private Assignment makeAssignment(Restaurant restaurant, Function function, Employee assignee) {
        var assignment = new Assignment();
        assignment.setRestaurant(restaurant);
        assignment.setFunction(function);
        assignment.setAssignee(assignee);
        assignment.setBeginDate(LocalDate.now());
        assignment.setEndDate(null);

        return assignmentRepository.save(assignment);
    }

    @Test
    void findByAssigneeId_shouldFindPerAssigneeId() {
        var restaurant = makeRestaurant("Restaurant");
        var equipier = makeFunction("Equipier");
        var manager = makeFunction("Manager");
        var alice = makeEmployee("Alice");
        var bob = makeEmployee("Bob");
        var charlie = makeEmployee("Charlie");

        makeAssignment(restaurant, equipier, alice);
        makeAssignment(restaurant, manager, alice);
        makeAssignment(restaurant, equipier, bob);

        assertEquals(2, assignmentRepository.findByAssigneeId(alice.getId()).count());
        assertEquals(1, assignmentRepository.findByAssigneeId(bob.getId()).count());
        assertEquals(0, assignmentRepository.findByAssigneeId(charlie.getId()).count());
    }
}
