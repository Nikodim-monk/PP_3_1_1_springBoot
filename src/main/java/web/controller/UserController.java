package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
//import web.dao.UserDaoImpl;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "usersAll";
    }
//
//    @GetMapping("/{id}")
//    public String printUserById(ModelMap model, @PathVariable("id") int id) {
//        model.addAttribute("user", userDao.getUserById(id));
//        return "user";
//    }
//
//    @PostMapping("/new")
//    public String createNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if(bindingResult.hasErrors()){return "redirect:/";}
//        userDao.addNewUser(user);
//        return "redirect:/";
//    }
//
//    @PatchMapping("/{id}")
//    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
//                             @PathVariable("id") int id) {
//        if(bindingResult.hasErrors()){return "redirect:/{id}";}
//        userDao.updateUser(user, id);
//        return "redirect:/";
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable("id") int id) {
//        userDao.UserDelete(id);
//        return "redirect:/";
//    }
}