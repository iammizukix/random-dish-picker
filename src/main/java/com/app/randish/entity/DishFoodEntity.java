package com.app.randish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "food_categories")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishFoodEntity {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
    private DishEntity dish;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")
    private FoodEntity food;
}

