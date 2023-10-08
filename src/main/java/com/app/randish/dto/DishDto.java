package com.app.randish.dto;

import com.app.randish.entity.DishEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DishDto {
    private Integer id;
    private String name;

    public static DishDto convert(DishEntity dish) {
        return new DishDto().setId(dish.getId()).setName(dish.getName());
    }
}
