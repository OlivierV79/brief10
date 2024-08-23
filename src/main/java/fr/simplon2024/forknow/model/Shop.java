package fr.simplon2024.forknow.model;

import java.util.List;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Shop {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @Builder.Default
    private String imageUrl = "image_de_base.jfif";

    private java.sql.Timestamp creation_date;

    @OneToMany(mappedBy = "shop")
    private List<UserInShop> userInShops;
    
}
