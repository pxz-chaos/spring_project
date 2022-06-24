package com.peixin.service;

import com.peixin.domain.Role;

import java.util.List;

public interface RoleService {

     List<Role> list();

    void save(Role role);
}
