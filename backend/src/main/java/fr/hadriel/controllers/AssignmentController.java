package fr.hadriel.controllers;

import org.springframework.web.bind.annotation.RestController;

import fr.hadriel.entities.Assignment;
import fr.hadriel.services.AssignmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PutMapping("/{assignmentId}/assign/{assigneeId}")
    public ResponseEntity<Assignment> assign(@PathVariable long assignmentId, @PathVariable long assigneeId) {
        try {
            var assignment = assignmentService.assign(assigneeId, assigneeId);
            return ResponseEntity.ok(assignment);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
