package com.app.randish.controller;


import com.app.randish.entity.DishEntity;
import com.app.randish.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    IndexService indexService;

    @GetMapping("/index")
    public String index(
            Model model,
            @ModelAttribute("dish") DishEntity dish
    ) {
        log.info("Top screen is displayed.");
        return "index";
    }

    @GetMapping("/random")
    public String random(
//            Model model
            RedirectAttributes redirectAttributes
    ) {
        log.info("Random dish is just picked.");
        redirectAttributes.addAttribute("dish", indexService.getRandDish());
        return "redirect:index";
    }


}
