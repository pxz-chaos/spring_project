package com.peixin.dao.impl;

import com.peixin.dao.RoleDao;
import com.peixin.domain.Role;
import com.peixin.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询
     *
     * @return 返回查询的结果
     */
    public List<Role> findAll() {
        List<Role> queryList = jdbcTemplate.query("select*from sys_role ", new BeanPropertyRowMapper<Role>(Role.class));

        return queryList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values(?,?,?)", null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUser(Long id) {
        String sql = "select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=?";
        List<Role> roles = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Role.class), id);
        return roles;
    }
}
