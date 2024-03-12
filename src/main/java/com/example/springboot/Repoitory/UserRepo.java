package com.example.springboot.Repoitory;

import com.example.springboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    public User findByEmail(String username);

    public User findByPasswordToken(String passwordToken);




}








