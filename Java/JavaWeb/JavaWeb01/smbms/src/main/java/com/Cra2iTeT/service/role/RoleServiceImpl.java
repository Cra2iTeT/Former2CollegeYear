package com.Cra2iTeT.service.role;

import com.Cra2iTeT.dao.BaseDao;
import com.Cra2iTeT.dao.role.RoleDao;
import com.Cra2iTeT.dao.role.RoleDaoImpl;
import com.Cra2iTeT.pojo.Role;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    //引入Dao
    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    @Override
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;
        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeConnection(connection, null, null);
        }
        return roleList;
    }







}
