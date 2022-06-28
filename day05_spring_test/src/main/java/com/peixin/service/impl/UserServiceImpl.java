package com.peixin.service.impl;

import com.peixin.dao.RoleDao;
import com.peixin.dao.UserDao;
import com.peixin.dao.impl.RoleDaoImpl;
import com.peixin.domain.Role;
import com.peixin.domain.User;
import com.peixin.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void del(Long userId) {
        //删除关系表，也就是sys_user_role中间表
        userDao.delUserRoleRel(userId);

        //删除sys_user主表
        userDao.del(userId);
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装userList中的每一个User的roles数据
        for (User user : userList) {
            //获得user的id
            Long id = user.getId();
            //将id作为参数，查询当前userID对应的Role集合数据
            List<Role> roles = roleDao.findRoleByUser(id);
            user.setRoles(roles);
        }

        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //1.向sys_user表中存储数据
        Long userId = userDao.save(user);
        //2.向sys_user_role 关系中存储多条数据
        userDao.saveUserRoleRel(userId, roleIds);
    }

    @Override
    public User login(String username, String password) {

        //try catch的快捷键Ctrl+alt+t
        User user = null;
        try {
            user = userDao.findByUsernameAndPassword(username, password);
            return user;
        } catch (Exception e) {
           return null;
        }

    }


}
