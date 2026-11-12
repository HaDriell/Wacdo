package fr.hadriel.controllers;

import org.springframework.web.bind.annotation.RestController;

import fr.hadriel.entities.Function;
import fr.hadriel.services.FunctionService;

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
@RequestMapping("/api/functions")
public class FunctionController {

    private final FunctionService functionService;

    public FunctionController(FunctionService functionService) {
        this.functionService = functionService;
    }

    @PostMapping("/create")
    public ResponseEntity<Function> create(@RequestBody Function function) {
        var result = functionService.create(function);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Function>> all() {
        List<Function> functions = functionService.all();
        return ResponseEntity.ok(functions);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Function> one(@PathVariable long id) {
        return functionService.find(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Function> update(@RequestBody Function function) {
        try {
            var updatedFunction = functionService.update(function);
            return ResponseEntity.ok(updatedFunction);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        functionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
