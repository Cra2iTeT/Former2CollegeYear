package com.Cra2iTeT;

import com.Cra2iTeT.mapper.UserMapper;
import com.Cra2iTeT.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        //参数是一个wrapper，条件构造器
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(20);
        user.setName("Cra2iTeT");
        user.setEmail("2373506982@qq.com");
        // 会自动生成id

        userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setAge(20);
        user.setName("Cra2iTeT");
        user.setEmail("2373506982@qq.com");

        userMapper.updateById(user);
    }

    //测试乐观锁成功
    @Test
    public void testLock() {
        User user = userMapper.selectById(6L);
        user.setName("TeTerrisy");

        userMapper.updateById(user);
    }

    //测试乐观锁不成功
    @Test
    public void testLockFailed() {
        User user = userMapper.selectById(6L);
        user.setName("Cra2iTeT11");

        User user2 = userMapper.selectById(6L);
        user2.setName("Cra2iTeT");

        userMapper.updateById(user2);
        userMapper.updateById(user);
    }

    //测试分页
    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 3);

        userMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
    }

    // 测试逻辑删除
    @Test
    public void testDelete() {
        User user = new User();
        User user1 = userMapper.selectById(11L);
        System.out.println(user1);
        user.setId(11L);
        userMapper.deleteById(user);

        User user2 = userMapper.selectById(11L);
        System.out.println("=======");
        System.out.println(user2);
    }
}
