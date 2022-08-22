package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", service.getAllUsers());
        return "usersAll";
    }

    @GetMapping("/{id}")
    public String printUserById(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", service.getUserById(id));
        return "user";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("user") User user) {
        service.addNewUser(user);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        service.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        service.UserDelete(id);
        return "redirect:/";
    }
}
