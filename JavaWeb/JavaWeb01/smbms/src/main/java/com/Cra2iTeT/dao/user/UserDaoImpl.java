package com.Cra2iTeT.dao.user;

import com.Cra2iTeT.dao.BaseDao;
import com.Cra2iTeT.pojo.Role;
import com.Cra2iTeT.pojo.User;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User getLoginUser(Connection connection, String userCode, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from smbms_user where userCode=? and userPassword=?";
            Object[] params = {userCode, password};

            resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setGender(resultSet.getInt("gender"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
                user.setUserRole(resultSet.getInt("userRole"));
                user.setCreatedBy(resultSet.getInt("createdBy"));
                user.setCreationDate(resultSet.getTimestamp("creationDate"));
                user.setModifyBy(resultSet.getInt("modifyBy"));
                user.setModifyDate(resultSet.getTimestamp("modifyDate"));
            }

            BaseDao.closeConnection(connection, preparedStatement, resultSet);

        }
        return user;
    }

    @Override
    public int updatePassword(Connection connection, int id, String userPassword) throws SQLException {
        PreparedStatement preparedStatement = null;
        int execute = 0;

        if (connection != null) {
            String sql = "update smbms_user set userPassword = ? where id = ?";

            Object[] params = {userPassword, id};
            execute = BaseDao.execute(connection, preparedStatement, sql, params);
            BaseDao.closeConnection(connection, preparedStatement, null);
        }

        return execute;
    }

    @Override
    public int getUserCount(Connection connection, String userName, int userRole) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;

        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");

            ArrayList<Object> list = new ArrayList<>();

            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                list.add("%" + userName + "%");
            }

            if (userRole > 0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }

            ResultSet rs = BaseDao.execute(connection, preparedStatement, resultSet, sql.toString(), list.toArray());

            if (rs.next()) {
                //从结果集中获得最后的数量
                count = rs.getInt("count");
            }
            BaseDao.closeConnection(null, preparedStatement, resultSet);
        }
        return count;
    }

    @Override
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");

            ArrayList<Object> list = new ArrayList<>();

            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                list.add("%" + userName + "%");
            }

            if (userRole > 0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }

            //在数据库中，分页使用limit(startIndex,pageSize,sum)
            //order by creationDate DESC按creationDate降序排序 asc是升序
            sql.append(" order by u.creationDate ASC limit ?,?");
            currentPageNo = (currentPageNo - 1) * pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            //System.out.println("sql in UserDao:"+sql);

            ResultSet rs = BaseDao.execute(connection, preparedStatement, resultSet, sql.toString(), list.toArray());

            while (rs.next()) {
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
                //System.out.print("t");
            }
            System.out.println("");
            BaseDao.closeConnection(null, preparedStatement, resultSet);
        }

        //System.out.println("userList.size() in functionDao:" + userList.size());
        return userList;
    }

    @Override
    public int add(Connection connection, List<Object> list) throws SQLException {
        PreparedStatement preparedStatement = null;
        int i = 0;
        if (connection != null) {
            String sql = "insert into smbms_user (`userCode`,`userName`,`userPassword`," +
                    "`userRole`,`gender`,`birthday`,`phone`,`address`)" +
                    "values(?,?,?,?,?,?,?,?)";
            i = BaseDao.execute(connection, preparedStatement, sql, list.toArray());
            BaseDao.closeConnection(connection, preparedStatement, null);
        }
        return i;
    }
}
