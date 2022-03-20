package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.User;
import com.Cra2iTeT.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行Sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭
        sqlSession.close();
    }

    @Test
    public void test2() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行Sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(2);
        System.out.println(user);

        //关闭
        sqlSession.close();
    }

    @Test
    public void test3() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行Sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        if (userMapper.addUser(new User(4, "王五", "123456")) > 0) {
            System.out.println("插入成功");
        }

        //提交事务
        sqlSession.commit();

        //关闭
        sqlSession.close();
    }

    @Test
    public void test4() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行Sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(4, "王五", "123456"));

        //提交事务
        sqlSession.commit();

        //关闭
        sqlSession.close();
    }

    @Test
    public void test5() {
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行Sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(4);

        //提交事务
        sqlSession.commit();

        //关闭
        sqlSession.close();
    }

}
