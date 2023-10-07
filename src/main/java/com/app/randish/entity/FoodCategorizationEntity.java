package com.app.randish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "food_categorization")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategorizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")
    private FoodEntity food;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_category_id")
    private FoodCategoryEntity category;
}

