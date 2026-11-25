package fr.hadriel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hadriel.model.Function;

public interface FunctionRepository extends JpaRepository<Function, Long> {

}
