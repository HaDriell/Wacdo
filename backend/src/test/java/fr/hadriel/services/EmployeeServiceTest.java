package fr.hadriel.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.hadriel.model.dto.EmployeeCreateDTO;

@SpringBootTest 
public class EmployeeServiceTest {

    @Autowired 
    private EmployeeService employeeService;

    @Test 
    public void shouldFilterEmployees() {
        var John = "John";
        var Lenna = "Lenna";
        var Snow = "Snow";
        var Chantemort = "Chantemort";

        employeeService.create(EmployeeCreateDTO.builder().firstName(John).lastName(Snow).email("john.snow@wacdo.fr").build());
        employeeService.create(EmployeeCreateDTO.builder().firstName(Lenna).lastName(Chantemort).email("lenna.chantemort@wacdo.fr").build());
    }
}
