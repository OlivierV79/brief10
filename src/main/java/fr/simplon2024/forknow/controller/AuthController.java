package fr.simplon2024.forknow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import fr.simplon2024.forknow.dto.RegisterDto;
import fr.simplon2024.forknow.dto.RegisterRestaurantDto;
import fr.simplon2024.forknow.dto.UserDto;
import fr.simplon2024.forknow.model.Shop;
import fr.simplon2024.forknow.model.User;
import fr.simplon2024.forknow.service.UserService;
import fr.simplon2024.forknow.service.RestaurantService;


@Controller
public class AuthController {
    private final UserService userService;
    private final RestaurantService restaurantService;

    @Autowired
    public AuthController(UserService userService, RestaurantService restaurantService) {
        this.userService = userService;
        this.restaurantService = restaurantService;

    }

    @GetMapping("/")
    public String home(Model model, Authentication authentication) {
        Optional<User> user = userService.from(authentication);
        if(user.isPresent()){
            model.addAttribute("currentUser", user.get());
        }
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @GetMapping("/restaurants-list")
    public String restaurantsList(Model model, Authentication authentication) {
        Optional<User> user = userService.from(authentication);
        if(user.isPresent()){
            model.addAttribute("currentUser", user.get());
        }

        List<Shop> restaurants = restaurantService.findAll();
        model.addAttribute("restaurants", restaurants);

        return "restaurants-list";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto user = new RegisterDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registerUser(@Valid @ModelAttribute RegisterDto userMapping) {
        System.out.println("Ok");
        if(!userMapping.getPassword().equals(userMapping.getPasswordConfirm())){
            return "redirect:/register?error";
        }
        userService.saveUser(userMapping);
        return "redirect:/login?success=userRegistred";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/restaurants-creation")
    public String restaurantsCreation(Model model) {
        RegisterRestaurantDto shop = new RegisterRestaurantDto();
        model.addAttribute("shop", shop);
        return "restaurants-creation";
    }

    @GetMapping("/restaurants-gestion")
    public String restaurantsgestion() {
        return "restaurants-gestion";
    }

    @PostMapping("/restaurants/save")
    public String registerRestaurant(@Valid @ModelAttribute RegisterRestaurantDto restaurantMapping, Authentication authentication) {
        System.out.println("Ok");

        
        
        restaurantService.saveRestaurant(restaurantMapping, authentication);
        
        return "redirect:/restaurants-list?success=restaurantRegistred";
    }

    
}
