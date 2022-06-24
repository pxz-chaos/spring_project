package com.peixin.dao;

import com.peixin.domain.Role;

import java.util.List;

public interface RoleDao {

    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUser(Long id);
}
