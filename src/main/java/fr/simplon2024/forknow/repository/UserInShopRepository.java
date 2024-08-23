package fr.simplon2024.forknow.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon2024.forknow.model.Shop;
import fr.simplon2024.forknow.model.User;
import fr.simplon2024.forknow.model.UserInShop;

@Repository
public interface UserInShopRepository extends JpaRepository<UserInShop, Long>{
    Optional<UserInShop> findByUserAndShop(User user, Shop shop);
}
