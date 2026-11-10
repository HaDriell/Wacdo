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

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> findRestaurantById(long id) {
        return restaurantRepository.findById(id);
    }

    public void deleteRestaurant(long id) {
        restaurantRepository.deleteById(id);
    }
}
