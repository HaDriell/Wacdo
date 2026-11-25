package fr.hadriel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.hadriel.model.Assignment;

import java.util.stream.Stream;


public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    @Query("select a from Assignment a where a.assignee.id = ?1")
    Stream<Assignment> findByAssigneeId(long assigneeId);

    @Query("select a from Assignment a where a.restaurant.id = ?1")
    Stream<Assignment> findByRestaurantId(long restaurantId);
}
