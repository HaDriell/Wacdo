package fr.hadriel.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hadriel.entities.Function;

public interface FunctionRepository extends JpaRepository<Function, Long> {

}
