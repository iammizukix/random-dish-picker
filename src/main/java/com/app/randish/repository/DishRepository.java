package com.app.randish.repository;

import com.app.randish.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Integer> {
//    Page<DishEntity> findAll(Pageable pageable);
}