package com.example.springboot.Controller;

import com.example.springboot.Entity.User;
import com.example.springboot.Payload.SignupRequest;
import com.example.springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller


public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") SignupRequest signupRequest) {
        return "register";
    }


    @PostMapping ("/registration")
    public String save(@ModelAttribute SignupRequest signupRequest) {
        if (userService.registerUser(signupRequest) != null) {
            return "login";
        }
        return "register";
    }
    @GetMapping("/StaffRegistration")
    public String getStaffRegistrationPage(@ModelAttribute("user") SignupRequest signupRequest) {
        return "StaffCreation";
    }

    @PostMapping("/StaffRegistration")
    public String saveStaff(@ModelAttribute("user") SignupRequest signupRequest, Model model) {
        if (userService.registerUser(signupRequest) != null) {
            return "login";
        }
        model.addAttribute("message", "Registered Successfuly!");
        return "StaffCreation";
    }


    @GetMapping("/user-list")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();

        model.addAttribute("users", userList);
        return "user-list"; // Create a new HTML page (user-list.html) to display the user table
    }







}
