package fr.simplon2024.forknow.service;

import java.util.List;

import fr.simplon2024.forknow.dto.RegisterRestaurantDto;
import fr.simplon2024.forknow.model.Shop;


public interface RestaurantService {
    void saveRestaurant(RegisterRestaurantDto restaurantMapping);
    void addUserToShop(Long userId, Long shopId);
    List<Shop> findAll();
}
