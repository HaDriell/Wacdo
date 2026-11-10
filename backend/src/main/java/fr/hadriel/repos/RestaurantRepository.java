package fr.hadriel.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.hadriel.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
