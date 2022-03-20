package com.Cra2iTeT.service.role;

import com.Cra2iTeT.pojo.Role;

import java.sql.Connection;
import java.util.List;

public interface RoleService {
    //获取角色列表
    public List<Role> getRoleList();
}
