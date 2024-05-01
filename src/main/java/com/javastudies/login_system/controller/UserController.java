package com.javastudies.login_system.controller;

import com.javastudies.login_system.model.UserDtls;
import com.javastudies.login_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @ModelAttribute
    private void userDetails(Model m, Principal p) {
        String userEmail = p.getName();
        UserDtls user = userRepo.findByEmail(userEmail);

        m.addAttribute("user", user);
    }

    @GetMapping("")
    public String home(){
        return "user/home";
    }

}
