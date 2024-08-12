package org.example.pp_3_1_1_springboot.controller;

import org.example.pp_3_1_1_springboot.model.User;
import org.example.pp_3_1_1_springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/users/add")
    public String showAddFrom(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User(name, email);
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String showEditFrom(Model model, @RequestParam Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userForm";
    }

    @PostMapping("/users/edit")
    public String editUser(@RequestParam Long id, @RequestParam String name, @RequestParam String email) {
        User user = userService.getUserById(id);
        user.setName(name);
        user.setEmail(email);
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
