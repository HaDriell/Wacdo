package fr.hadriel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.hadriel.entities.Function;
import fr.hadriel.repos.FunctionRepository;

@Service
public class FunctionService {

    private final FunctionRepository functionRepository;

    public FunctionService(FunctionRepository functionRepository) {
        this.functionRepository = functionRepository;
    }

    public Function create(Function function) {
        if (function.getId() != 0) {
            throw new RuntimeException();
        }
        return functionRepository.save(function);
    }

    public Function update(Function Function) {
        functionRepository.findById(Function.getId()).orElseThrow();
        return functionRepository.save(Function);
    }

    public void delete(long id) {
        functionRepository.deleteById(id);
    }

    public Optional<Function> find(long id) {
        return functionRepository.findById(id);
    }

    public List<Function> all() {
        return functionRepository.findAll();
    }
}
