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

    public Function savefunction(Function function) {
        return functionRepository.save(function);
    }

    public List<Function> getAllFunctions() {
        return functionRepository.findAll();
    }

    public Optional<Function> findFunctionById(long id) {
        return functionRepository.findById(id);
    }

    public void deleteFunction(long id) {
        functionRepository.deleteById(id);
    }
}
