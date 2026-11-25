package fr.hadriel.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.hadriel.model.Restaurant;

@SpringBootTest
public class RestaurantServiceTest {

    @Autowired 
    private RestaurantService restaurantService;

    // TODO : test CRUD operations

    @Test 
    void shouldFilterRestaurants() {
        final var Wacdo = "Wacdo";
        final var KFC = "KFC";
        final var ZipLyon1 = "69001";
        final var ZipLyon2 = "69002";
        final var ZipAnnecy = "74000";
        final var Lyon = "Lyon";
        final var Annecy = "Annecy";
        final var Unknown = "Unknown";

        restaurantService.create(Restaurant.builder().name(Wacdo).zipCode(ZipLyon1).city(Lyon).build());
        restaurantService.create(Restaurant.builder().name(KFC).zipCode(ZipLyon1).city(Lyon).build());
        restaurantService.create(Restaurant.builder().name(Wacdo).zipCode(ZipLyon2).city(Lyon).build());
        restaurantService.create(Restaurant.builder().name(Wacdo).zipCode(ZipAnnecy).city(Annecy).build());
        restaurantService.create(Restaurant.builder().name(KFC).zipCode(ZipAnnecy).city(Annecy).build());

        // Various grouped criterias
        assertEquals(3, restaurantService.filtered(Wacdo, null, null).size());
        assertEquals(2, restaurantService.filtered(KFC, null, null).size());
        assertEquals(1, restaurantService.filtered(KFC, null, Lyon).size());
        assertEquals(1, restaurantService.filtered(KFC, null, Annecy).size());
        assertEquals(2, restaurantService.filtered(Wacdo, null, Lyon).size());
        assertEquals(1, restaurantService.filtered(Wacdo, null, Annecy).size());

        // Should not find anything with "Unknown" criterias
        assertEquals(0, restaurantService.filtered(Unknown, null, null).size());
        assertEquals(0, restaurantService.filtered(null, Unknown, null).size());
        assertEquals(0, restaurantService.filtered(null, null, Unknown).size());

        // Exact match for each inserted element
        assertEquals(1, restaurantService.filtered(Wacdo, ZipLyon1, Lyon).size());
        assertEquals(1, restaurantService.filtered(KFC, ZipLyon1, Lyon).size());
        assertEquals(1, restaurantService.filtered(Wacdo, ZipLyon2, Lyon).size());
        assertEquals(1, restaurantService.filtered(Wacdo, ZipAnnecy, Annecy).size());
        assertEquals(1, restaurantService.filtered(KFC, ZipAnnecy, Annecy).size());
    }
}
