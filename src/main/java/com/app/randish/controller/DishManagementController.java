package com.app.randish.controller;


import com.app.randish.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/dishes")
public class DishManagementController {

    @Autowired
    DishService dishService;

    @GetMapping
    public String dishes(
            Model model
    ) {
        model.addAttribute("dishes", dishService.getAllDishes());
        return "dishes";
    }


}
