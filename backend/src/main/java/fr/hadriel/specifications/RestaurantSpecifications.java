package fr.hadriel.specifications;

import org.springframework.data.jpa.domain.Specification;

import fr.hadriel.entities.Restaurant;

public class RestaurantSpecifications {

    public static Specification<Restaurant> hasName(String name) {
        return (root, query, cb) -> name == null ? null : cb.equal(root.get("name"), name);   
    }

    public static Specification<Restaurant> hasZipCode(String zipCode) {
        return (root, query, cb) -> zipCode == null ? null : cb.equal(root.get("zipCode"), zipCode);
    }

    public static Specification<Restaurant> inCity(String city) {
        return (root, query, cb) -> city == null ? null : cb.equal(root.get("city"), city);
    }

}
