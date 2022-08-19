package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Repository.UserDao;
import web.model.User;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "usersAll";
    }

    @GetMapping("/{id}")
    public String printUserById(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", userDao.getUserById(id));
        return "user";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "redirect:/";}
        userDao.addNewUser(user);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "redirect:/{id}";}
        userDao.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userDao.UserDelete(id);
        return "redirect:/";
    }
}
