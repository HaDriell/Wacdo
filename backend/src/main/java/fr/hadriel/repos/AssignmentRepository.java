package fr.hadriel.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hadriel.entities.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {   
}
