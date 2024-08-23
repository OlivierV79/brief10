package fr.simplon2024.forknow.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon2024.forknow.dto.RegisterRestaurantDto;
import fr.simplon2024.forknow.model.Shop;
import fr.simplon2024.forknow.model.User;
import fr.simplon2024.forknow.model.UserInShop;
import fr.simplon2024.forknow.repository.RestaurantRepository;
import fr.simplon2024.forknow.repository.UserInShopRepository;
import fr.simplon2024.forknow.repository.UserRepository;
import fr.simplon2024.forknow.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final UserInShopRepository userInShopRepository;

  

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository,UserRepository userRepository,UserInShopRepository userInShopRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.userInShopRepository = userInShopRepository;
    }
    
    @Override
    public void saveRestaurant(RegisterRestaurantDto restaurant) {
        Shop restaurantEntity = Shop.builder()
            .name(restaurant.getName())
            .creation_date(java.sql.Timestamp.valueOf(LocalDateTime.now()))
            .build();
        restaurantRepository.save(restaurantEntity);
  
    }

    @Override
    public void addUserToShop(Long userId, Long shopId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Shop shop = restaurantRepository.findById(shopId).orElseThrow(() -> new RuntimeException("Shop not found"));

        UserInShop userInShop = UserInShop.builder()
            .user(user)
            .shop(shop)
            .creation_date(java.sql.Timestamp.valueOf(LocalDateTime.now()))
            .build();

        userInShopRepository.save(userInShop);
    }

    

    @Override
    public List<Shop> findAll() {
        return restaurantRepository.findAll();
    }

    
}
