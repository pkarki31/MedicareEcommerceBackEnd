package com.finalproject.medicare.service;

import com.finalproject.medicare.entity.LoginResponse;
import com.finalproject.medicare.entity.Users;

public interface LoginService {

    LoginResponse login(String username, String password);

    Users saveUsers(Users usr);
}
