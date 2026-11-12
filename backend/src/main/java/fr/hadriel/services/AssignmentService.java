package fr.hadriel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.hadriel.entities.Assignment;
import fr.hadriel.repos.AssignmentRepository;

@Service 
public class AssignmentService {
    
    private final AssignmentRepository assignmentRepository;

    public AssignmentService(
        AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment create(Assignment assignment) {
        if (assignment.getId() != 0) {
            throw new RuntimeException();
        }
        return assignmentRepository.save(assignment);
    }

    public Assignment update(Assignment assignment) {
        assignmentRepository.findById(assignment.getId()).orElseThrow();
        return assignmentRepository.save(assignment);
    }

    public void delete(long id) {
        assignmentRepository.deleteById(id);
    }

    public Optional<Assignment> find(long id) {
        return assignmentRepository.findById(id);
    }

    public List<Assignment> all() {
        return assignmentRepository.findAll();
    }
}
