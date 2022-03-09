package com.finalproject.medicare.service.impl;

import com.finalproject.medicare.entity.LoginResponse;
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
    public LoginResponse login(String username, String password) {

        System.out.println("email_id impl : "+username);
        System.out.println("password impl : "+password);

        boolean isAdmin =true;
        String userVerified=null;
        LoginResponse loginResponse = new LoginResponse();

        try{
            Users user = loginRepository.findByUsernameAndPassword(username, password);
            System.out.println("User found is Admin  : " + user.isIsadmin());
            isAdmin = new Boolean(user.isIsadmin());

            userVerified="User Present ";

            loginResponse.setUserVerified(userVerified);
            loginResponse.setAdminIs(isAdmin);
        }
        catch (NullPointerException ex){

            isAdmin = false;
            userVerified="User Not Present ";

            loginResponse.setUserVerified(userVerified);
            loginResponse.setAdminIs(isAdmin);

        }

        return loginResponse;

    }

    @Override
    public Users saveUsers(Users usr) {

        Users user = loginRepository.save(usr);
        return user;
    }
}
