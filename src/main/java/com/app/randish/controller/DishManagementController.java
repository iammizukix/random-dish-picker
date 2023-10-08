package com.app.randish.controller;


import com.app.randish.dto.DishDto;
import com.app.randish.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        log.info("All dishes displayed.");
        model.addAttribute("dishes", dishService.getAllDishes());
        model.addAttribute("form", new DishDto());
        return "dishes";
    }

    @PostMapping("/create")
    public String create(
            Model model,
            DishDto form
    ) {
        dishService.create(form);
        log.info("New dish created successfully.");
        return "redirect:/dishes";
    }

    @PostMapping("/remove")
    public String remove(
            Model model,
            @RequestParam("id") Integer id
    ) {
        dishService.removeById(id);
        log.info("The dish removed successfully.");
        return "redirect:/dishes";
    }

}
