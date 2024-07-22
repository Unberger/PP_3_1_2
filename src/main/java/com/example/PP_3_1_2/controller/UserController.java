package com.example.PP_3_1_2.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.PP_3_1_2.model.User;
import com.example.PP_3_1_2.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "showAll";
    }

    @GetMapping("/user/new")
    public String createUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/new";
        userService.save(user);
        return "redirect:/users/";
    }

    @GetMapping("/user")
    public String showUser(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @PatchMapping("/user/edit")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @RequestParam(value = "id") int id) {
        if (bindingResult.hasErrors())
            return "/show";
        userService.update(id, user);
        return "redirect:/users/";
    }

    @DeleteMapping("/user/delete")
    public String delete(@RequestParam(value = "id") int id) {
        userService.delete(id);

        return "redirect:/users/";
    }


}

