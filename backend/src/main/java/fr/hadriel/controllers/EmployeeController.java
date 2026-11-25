package fr.hadriel.controllers;

import org.springframework.web.bind.annotation.RestController;

import fr.hadriel.model.dto.EmployeeCreateDTO;
import fr.hadriel.model.dto.EmployeeDTO;
import fr.hadriel.model.dto.EmployeeUpdateDTO;
import fr.hadriel.services.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeCreateDTO employee) {
        var result = employeeService.create(employee);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> all() {
        List<EmployeeDTO> assignments = employeeService.all();
        return ResponseEntity.ok(assignments);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> one(@PathVariable long id) {
        return employeeService.find(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable long id, @RequestBody EmployeeUpdateDTO dto) {
        try {
            var updatedEmployee = employeeService.update(id, dto);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
