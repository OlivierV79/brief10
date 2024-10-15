package fr.simplon2024.forknow.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRestaurantDto {
    @NotEmpty(message = "name must not be empty")
    private String name;
}
