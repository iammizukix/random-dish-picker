package com.app.randish.service;

import com.app.randish.entity.DishEntity;
import com.app.randish.repository.DishRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IndexService {
    @Autowired
    DishRepository dishRepository;

    public String getRandDishName() {
        long count = dishRepository.count();
        int idx = (int) (Math.random() * count);
        DishEntity dish = dishRepository.findAll(PageRequest.of(idx, 1)).getContent().get(0);
        return dish.getName();
    }
}
