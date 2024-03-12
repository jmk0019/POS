package com.example.springboot.Service;

import com.example.springboot.Entity.User;
import com.example.springboot.Payload.LoginRequest;
import com.example.springboot.Payload.SignupRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    public User registerUser(SignupRequest signupRequest);
    public String generateOtp(User user);

    public User saveOtpDetails(LoginRequest loginRequest);

    public String sendResetEmail(String email, HttpServletRequest request);

    public String updatePassword(LoginRequest loginRequest);





    List<User> getAllUsers();

    User getUserById(Long userId);

    void updateUser(User user);






}
