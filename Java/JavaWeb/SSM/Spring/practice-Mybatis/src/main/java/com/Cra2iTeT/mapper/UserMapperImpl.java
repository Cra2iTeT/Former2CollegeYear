package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private SqlSessionTemplate sessionTemplate;

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    @Override
    public List<User> selectUser() {
        UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
        return userMapper.selectUser();
    }
}
