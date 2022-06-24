package com.peixin.service.impl;

import com.peixin.dao.RoleDao;
import com.peixin.dao.impl.RoleDaoImpl;
import com.peixin.domain.Role;
import com.peixin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
