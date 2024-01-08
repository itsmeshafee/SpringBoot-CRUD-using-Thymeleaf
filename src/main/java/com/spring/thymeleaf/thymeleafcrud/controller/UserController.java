package com.spring.thymeleaf.thymeleafcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.spring.thymeleaf.thymeleafcrud.entity.User;
import com.spring.thymeleaf.thymeleafcrud.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    private String getAllUsers(Model model)
    {
        model.addAttribute("users",userService.getAllUsers());
        return "home";
    }

    @GetMapping("/adduserform")
    public String addUser(Model model)
    {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/submituser")
    public String saveUser(@ModelAttribute("user") User user)
    {
        System.out.println(user);
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/updateuser/{id}")
    public String updateById(@PathVariable("id") int id, Model model)
    {
        User user = userService.updateById(id);
        model.addAttribute("user", user);
        userService.addUser(user);
        return "update_user";
    }

    @GetMapping("/deleteuser/{id}")
    public String deleteUserByIdI(@PathVariable(value = "id") int id)
    {
        System.out.println(id);
        userService.deleteUserById(id);
        return "redirect:/users";
    }
    
}
