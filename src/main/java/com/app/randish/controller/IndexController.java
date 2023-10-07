package com.app.randish.controller;


import com.app.randish.entity.DishEntity;
import com.app.randish.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/index")
public class IndexController {

    @Autowired
    DishService dishService;

    @GetMapping
    public String index(
            Model model,
            @ModelAttribute("dish") DishEntity dish
    ) {
        log.info("Top screen is displayed.");
        return "index";
    }

    @GetMapping("/random")
    public String random(
            RedirectAttributes redirectAttributes
    ) {
        log.info("Random dish is just picked.");
        redirectAttributes.addAttribute("dish", dishService.getRandDish());
        return "redirect:index";
    }


}
