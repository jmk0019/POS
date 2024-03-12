package com.example.springboot.Controller;

import com.example.springboot.Payload.LoginRequest;
import com.example.springboot.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forgot")
public class ForgotPasswordController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String forgotPassword(){


        return "forgotpwd";
    }

    @PostMapping("/sendemail")
    public String getUsername(@ModelAttribute("username") String email, HttpServletRequest request, Model model) {
        System.out.println("sendemail controller" + email);
        String result = userService.sendResetEmail(email, request);
        if(result != null) {
            model.addAttribute("message", "We have sent a reset password link to your email. Please check ?");
            return "resetemail";
        }else {
            return "redirect:?error";
        }
    }
    @GetMapping("/changePwd")
    public String changePwd(@ModelAttribute("token") String token, Model model){
        model.addAttribute("token", token);
        return "changepwd";
    }

    @PostMapping("/resetpwd")
    public String resetPassword(@ModelAttribute LoginRequest loginRequest, Model model) {
        System.out.println("Controller" +loginRequest);
        String result = userService.updatePassword(loginRequest);
        if(result != null) {
            model.addAttribute("message", "Your password has been reset successfully !");
            return "login";
        }
        return "redirect:changePwd?error";
    }


}
