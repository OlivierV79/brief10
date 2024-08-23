package fr.simplon2024.forknow.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import fr.simplon2024.forknow.model.Shop;


@Repository
public interface RestaurantRepository extends JpaRepository<Shop, Long>{
    
}
