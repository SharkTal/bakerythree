package com.example.bakerythree.web;

import com.example.bakerythree.service.UserService;
import com.example.bakerythree.web.dto.UserRegistrationDto;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){

        return new UserRegistrationDto();
    }


    @GetMapping("/registration")
    public String showRegistrationForm(){

        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/sign-in")
    public String signIn(){
        return "sign-in";
    }

}
