package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.User;
import com.Cra2iTeT.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @Test
//    public void test2() {
//        //获得sqlSession对象
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        //执行Sql
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        User user = userMapper.getUserById(2);
//        System.out.println(user);
//
//        //关闭
//        sqlSession.close();
//    }
//
//    @Test
//    public void test3() {
//        //获得sqlSession对象
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        //执行Sql
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        if (userMapper.addUser(new User(4, "王五", "123456")) > 0) {
//            System.out.println("插入成功");
//        }
//
//        //提交事务
//        sqlSession.commit();
//
//        //关闭
//        sqlSession.close();
//    }
//
//    @Test
//    public void test4() {
//        //获得sqlSession对象
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        //执行Sql
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        userMapper.updateUser(new User(4, "王五", "123456"));
//
//        //提交事务
//        sqlSession.commit();
//
//        //关闭
//        sqlSession.close();
//    }
//
//    @Test
//    public void test5() {
//        //获得sqlSession对象
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        //执行Sql
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        userMapper.deleteUser(4);
//
//        //提交事务
//        sqlSession.commit();
//
//        //关闭
//        sqlSession.close();
//    }
//
//    @Test
//    public void test06() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("startIndex", 0);
//        hashMap.put("pageSize", 2);
//
//        List<User> userList = mapper.selectUser(hashMap);
//
//        for (User _user : userList) {
//            System.out.println(_user);
//        }
//
//        sqlSession.close();
//    }

    @Test
    public void testUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        int currentPage = 2;  //第几页
        int pageSize = 2;  //每页显示几个
        RowBounds rowBounds = new RowBounds((currentPage - 1) * pageSize, pageSize);

        //通过session.**方法进行传递rowBounds，[此种方式现在已经不推荐使用了]
        List<User> users = sqlSession.selectList("com.Cra2iTeT.mapper.UserMapper.getUserByRowBounds", null, rowBounds);

        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
