package fr.hadriel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import fr.hadriel.entities.Restaurant;
import fr.hadriel.repos.RestaurantRepository;
import fr.hadriel.specifications.RestaurantSpecifications;

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

    public Restaurant update(Restaurant restaurant) {
        restaurantRepository.findById(restaurant.getId()).orElseThrow();
        return restaurantRepository.save(restaurant);
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

    public List<Restaurant> filtered(String name, String zipCode, String city) {
        Specification<Restaurant> spec = Specification
            .where(RestaurantSpecifications.hasName(name))
            .and(RestaurantSpecifications.hasZipCode(zipCode))
            .and(RestaurantSpecifications.inCity(city));
        
        return restaurantRepository.findAll(spec);
    }
}
