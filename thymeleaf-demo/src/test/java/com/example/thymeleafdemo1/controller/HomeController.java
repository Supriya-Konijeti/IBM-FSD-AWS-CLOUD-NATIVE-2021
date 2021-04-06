package com.example.thymeleafdemo1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model)
    {
        model.addAttribute("theDate",new Date());
        return "home";
    }
}