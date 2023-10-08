package com.app.randish.controller;


import com.app.randish.dto.DishDto;
import com.app.randish.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/index")
public class IndexController {

    @Autowired
    DishService dishService;

    @GetMapping
    public String index(
            Model model
    ) {
        log.info("Top screen is displayed.");
        model.addAttribute("dish", new DishDto());
        return "index";
    }

    @GetMapping("/random")
    public String random(
            Model model,
            @ModelAttribute("dish") DishDto dish
    ) {
        log.info("Random dish is just picked.");
        model.addAttribute("dish", dishService.getRandDish());
        return "index";
    }


}
