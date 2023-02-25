package com.app.randish.controller;


import com.app.randish.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    IndexService indexService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/random")
    public String random(
            Model model
    ) {
//        model.addAttribute("dish", indexService.getRandDishName());
        return "redirect/index";
    }


}
