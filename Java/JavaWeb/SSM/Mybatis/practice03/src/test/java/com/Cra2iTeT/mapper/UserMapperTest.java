package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.User;
import com.Cra2iTeT.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        /*查询所有
        List<User> list = mapper.getUserList();
        for (User _user : list) {
            System.out.println(_user);
        }*/

        /*根据id查询
        User user = mapper.getUserById(1);
        System.out.println(user);*/

        /*增
        mapper.addUser(new User(5, "admin", "123456"));
         */

        /*改
        mapper.updateUser(new User(5,"Admin","123456"));
         */

        /*删
        mapper.deleteUser(5);
         */

        sqlSession.close();
    }

}
