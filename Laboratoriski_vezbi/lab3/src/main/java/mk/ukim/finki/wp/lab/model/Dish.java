package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name="dishes")
@Entity
public class Dish {

    @Id
    @GeneratedValue
    private Long id;

    private String dishId;

    private String name;

    private String cuisine;

    private int preparationTime;

    //chef-id
    @ManyToOne
    private Chef chef;

    @Enumerated(EnumType.STRING)
    private DishRank rank;  //novo pole za rank

    private double rating;  //novo pole za rating

    public Dish(String dishId, String name, String cuisine, int preparationTime, Chef chef, DishRank rank, double rating) {
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.chef = chef;
        this.rank = rank;
        this.rating = rating;
    }
}
