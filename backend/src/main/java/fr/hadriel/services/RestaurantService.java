package fr.hadriel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.hadriel.entities.Restaurant;
import fr.hadriel.repos.RestaurantRepository;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant create(Restaurant restaurant) {
        if (restaurant.getId() != 0) {
            throw new RuntimeException();
        }
        return restaurantRepository.save(restaurant);
    }

    public Restaurant update(Restaurant Restaurant) {
        restaurantRepository.findById(Restaurant.getId()).orElseThrow();
        return restaurantRepository.save(Restaurant);
    }

    public void delete(long id) {
        restaurantRepository.deleteById(id);
    }

    public Optional<Restaurant> find(long id) {
        return restaurantRepository.findById(id);
    }

    public List<Restaurant> all() {
        return restaurantRepository.findAll();
    }
}
