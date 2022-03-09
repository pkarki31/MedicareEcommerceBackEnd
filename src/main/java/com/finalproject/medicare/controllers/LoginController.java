package com.finalproject.medicare.controllers;

import com.finalproject.medicare.entity.LoginResponse;
import com.finalproject.medicare.entity.Users;
import com.finalproject.medicare.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicare")
public class LoginController {

    @Autowired
    LoginService service;

    // API : localhost:8080/medicare/isAdmin?username=admin&password=admin
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value ="/isAdmin",consumes = {"application/json"},produces = {"application/json"})
    public LoginResponse getUserID(@RequestBody Users user) {

        LoginResponse loggedInUser = service.login(user.getUsername(),user.getPassword());

        return loggedInUser;

    }

    // API : localhost:8080/medicare/createUser/
    @PostMapping(value = "/createUser",consumes = {"application/json"},produces = {"application/json"})
    public Users createUser(@RequestBody Users user){

        Users users = service.saveUsers(user);
        return users;
    }

    @GetMapping("/welcome")
    public String welcome(){

        return "welcome";
    }


}
