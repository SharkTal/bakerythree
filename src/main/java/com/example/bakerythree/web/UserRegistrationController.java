package com.example.bakerythree.web;

import com.example.bakerythree.domain.Bread;
import com.example.bakerythree.domain.BreadRepository;
import com.example.bakerythree.domain.TypeRepository;
import com.example.bakerythree.service.UserService;
import com.example.bakerythree.web.dto.UserRegistrationDto;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserRegistrationController {
    @Autowired
    private BreadRepository breadRepository;

    @Autowired
    private TypeRepository typeRepository;


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
    public String home(Model model){
        model.addAttribute("breads", breadRepository.findAll());
        return "breadlist";
    }

    @GetMapping("/sign-in")
    public String signIn(){
        return "sign-in";
    }


    @GetMapping(value = "/breadlist")
    public String breadList(Model modle){
        modle.addAttribute("breads", breadRepository.findAll());
        return "breadlist";
    }

    @GetMapping(value = "/add")
    public String addBread(Model model){
        model.addAttribute("bread", new Bread());
        model.addAttribute("types", typeRepository.findAll());
        return "addbread";
    }

    @PostMapping(value = "/save")
    public String save(Bread bread){
        breadRepository.save(bread);
        return "redirect:breadlist";
    }

    @GetMapping(value = "/edit/{id}")
    public String editBread(@PathVariable("id") Long id, Model model){
        model.addAttribute("bread", breadRepository.findAllById(id));
        model.addAttribute("types", typeRepository.findAll());
        return "editbread";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteBread(@PathVariable("id") Long id){
        breadRepository.deleteById(id);
        return "redirect:../breadlist";
    }

    //RESTful service to get all breads
    @RequestMapping(value = "/breads")
    public @ResponseBody Iterable<Bread> getBreads(){
        return breadRepository.findAll();
    }

    //Restful service to find bread by id using path variable
    @GetMapping(value = "/bread/{id}")
    public @ResponseBody Bread findByIdRest(@PathVariable("id") Long breadId){
        return breadRepository.findAllById(breadId);
    }



}
