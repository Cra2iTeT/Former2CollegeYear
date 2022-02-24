package com.Cra2iTeT.service.user;

import com.Cra2iTeT.dao.BaseDao;
import com.Cra2iTeT.dao.user.UserDao;
import com.Cra2iTeT.dao.user.UserDaoImpl;
import com.Cra2iTeT.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    //业务层都会调用Dao层，我们要引用Dao
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体的数据库操作
            user = userDao.getLoginUser(connection, userCode, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeConnection(connection, null, null);
        }
        return user;
    }

    @Override
    public Boolean updatePassword(int id, String userPassword) {
        Connection connection = null;

        boolean flag = false;
        //得到连接
        connection = BaseDao.getConnection();
        try {
            if (userDao.updatePassword(connection, id, userPassword) > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeConnection(connection, null, null);
        }

        return flag;
    }

    @Override
    public int getUserCount(String username, int userRole) {
        Connection connection = null;
        int count = 0;

        try {
            connection = BaseDao.getConnection();
            UserDao userDao = new UserDaoImpl();
            count = userDao.getUserCount(connection, username, userRole);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeConnection(connection, null, null);
        }

        return count;
    }

    @Override
    public List<User> getUserList(String queryUsername, int queryUserRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<User> userList = new ArrayList<>();

        try {
            connection = BaseDao.getConnection();
            UserDaoImpl userDao = new UserDaoImpl();
            userList = userDao.getUserList(connection, queryUsername, queryUserRole, currentPageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeConnection(connection, null, null);
        }
        //System.out.println("userList.size() in functionService:"+userList.size());
        return userList;
    }

    @Override
    public int add(List<Object> list) {
        Connection connection = null;
        int i = 0;

        try {
            connection = BaseDao.getConnection();
            i = userDao.add(connection, list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeConnection(connection, null, null);
        }
        return i;
    }
}
