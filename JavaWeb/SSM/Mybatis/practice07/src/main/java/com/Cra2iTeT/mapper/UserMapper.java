package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User queryUserById(@Param("id") int id);
}
