package com.javastudies.login_system.controller;

import com.javastudies.login_system.model.UserDtls;
import com.javastudies.login_system.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }

    @PostMapping("/create-user")
    public String saveUser(@ModelAttribute UserDtls userDtls, HttpSession session){
        System.out.println("CHEGOU AQUI - Register");
        // Check if email already exists
        if(userService.checkEmail(userDtls.getEmail())) {
            session.setAttribute("msg", "Email already registered!");
         return "redirect:/register";
        }

        if(userService.createUser(userDtls) != null){
            System.out.println("Criou o Usuário");
        } else {
            System.out.println("Não criou");
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
