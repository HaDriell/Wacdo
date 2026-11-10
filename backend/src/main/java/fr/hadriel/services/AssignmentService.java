package fr.hadriel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.hadriel.entities.Assignment;
import fr.hadriel.repos.AssignmentRepository;
import fr.hadriel.repos.EmployeeRepository;

@Service 
public class AssignmentService {
    
    private final AssignmentRepository assignmentRepository;
    private final EmployeeRepository employeeRepository;

    public AssignmentService(
        AssignmentRepository assignmentRepository, 
        EmployeeRepository employeeRepository) {
        this.assignmentRepository = assignmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public Assignment saveAssignemt(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> findAssignmentById(long id) {
        return assignmentRepository.findById(id);
    }

    public void deleteAssignment(long id) {
        assignmentRepository.deleteById(id);
    }

    public Assignment assign(long assignmentId, long assigneeId) {
        var assignment = assignmentRepository.findById(assignmentId).orElseThrow(() -> new RuntimeException("Assignment not found"));
        var assignee = employeeRepository.findById(assigneeId).orElseThrow(() -> new RuntimeException("Assignee not found"));

        assignment.setAssignee(assignee);

        return assignmentRepository.save(assignment);
    }
}
