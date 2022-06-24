package com.peixin.service;

import com.peixin.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);
}
