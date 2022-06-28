package com.peixin.service;

import com.peixin.domain.User;

import java.util.List;

public interface UserService {
    void del(Long userId);

    List<User> list();

    void save(User user, Long[] roleIds);

    User login(String username, String password);
}
