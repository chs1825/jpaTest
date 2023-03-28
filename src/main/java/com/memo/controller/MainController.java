package com.memo.controller;

import com.memo.entity.User;
import com.memo.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private UserService service;

//    public MainController(UserService service) {
//        this.service = service;
//    }

    @GetMapping("/")
    public String start(@NotNull Model model){

        String id = "chs1825";
//        User user = service.getUserById(id);
        model.addAttribute("data", service.getAll());
        return "first";
    }


}
