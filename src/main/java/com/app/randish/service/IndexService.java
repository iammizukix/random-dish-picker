package com.app.randish.service;

import com.app.randish.entity.DishEntity;
import com.app.randish.repository.DishRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IndexService {
    @Autowired
    DishRepository dishRepository;

    public DishEntity getRandDish() {
        List<DishEntity> dishes = dishRepository.findAll();
        int count = dishes.size();
        int idx = (int) (Math.random() * count);
        return dishes.get(idx);
    }
}
