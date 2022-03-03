package com.finalproject.medicare.service.impl;

import com.finalproject.medicare.entity.Users;
import com.finalproject.medicare.repository.loginrepository;
import com.finalproject.medicare.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private loginrepository loginRepository;

    @Override
    public String login(String username, String password) {

        System.out.println("email_id impl : "+username);
        System.out.println("password impl : "+password);

        String isAdmin =null;
        String userVerified=null;

        try{
            Users user = loginRepository.findByUsernameAndPassword(username, password);
            System.out.println("User found is Admin  : " + user.isIsadmin());
            isAdmin = new Boolean(user.isIsadmin()). toString();
            userVerified="User Present ";
        }
        catch (NullPointerException ex){

            isAdmin = " UserName or Password is Incorrect !";
            userVerified="User Not Present ";

        }

        return userVerified +"," +isAdmin;

    }

    @Override
    public Users saveUsers(Users usr) {

        Users user = loginRepository.save(usr);
        return user;
    }
}
