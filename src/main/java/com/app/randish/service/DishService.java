package com.app.randish.service;

import com.app.randish.dto.DishDto;
import com.app.randish.entity.DishEntity;
import com.app.randish.repository.DishRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DishService {
    @Autowired
    DishRepository dishRepository;

    public List<DishDto> getAllDishes() {
        return dishRepository.findAll().stream().map(DishDto::convert).toList();
    }

    public DishDto getRandDish() {
        List<DishEntity> dishes = dishRepository.findAll();
        int count = dishes.size();
        if(count == 0){
            return new DishDto();
        }
        int idx = (int) (Math.random() * count);
        return DishDto.convert(dishes.get(idx));
    }
}
