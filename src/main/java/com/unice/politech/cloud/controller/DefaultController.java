package com.unice.politech.cloud.controller;

import com.unice.politech.cloud.service.CounterService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class DefaultController {
    @Autowired
    CounterService counterService;

    @GetMapping("/**")
    public String index(HttpServletRequest request, Model model) {
        String currentRoute = request.getRequestURI();
        counterService.increment(currentRoute);
        model.addAttribute("counters", counterService.findAll());
        return "index";
    }
}
