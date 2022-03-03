package com.finalproject.medicare.service;

import com.finalproject.medicare.entity.Users;

public interface LoginService {

    String login(String username, String password);

    Users saveUsers(Users usr);
}
