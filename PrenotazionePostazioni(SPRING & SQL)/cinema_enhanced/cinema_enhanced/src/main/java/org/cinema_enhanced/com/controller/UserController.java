package org.cinema_enhanced.com.controller;

import org.cinema_enhanced.com.service.*;
import org.cinema_enhanced.com.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/prenotazioni")
public class UserController {
    @Autowired
    private LoginService loginService;

    @GetMapping
    public String showLoginPage(){
        return "login/login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        User loggedUser = loginService.doLogin(username, password);
        if(loggedUser != null){
            return "redirect:/azione/seldata/" + loggedUser.getId();
        }
        model.addAttribute("message", "Invalid User or Password");
        return "login/login";
    }

}
