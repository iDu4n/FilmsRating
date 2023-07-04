package com.itdep.portalbackend.controller;

import com.itdep.portalbackend.model.User;
import com.itdep.portalbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/hello")
    public String showHelloPage(User user) {
        return "hello";
    }

    @PostMapping("/login")
    public String getEmailAndPassword(@RequestParam String email,
                                      @RequestParam String password) {
        userService.getEmailAndPassword(email, password);
        return "home";
    }

    @GetMapping("/home")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "home";
    }


    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/home/";
    }

    @GetMapping("/user-update")
    public String userUpdate(){
        return "user-update";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.saveUser(user);
        return "redirect:/home/";
    }

}
