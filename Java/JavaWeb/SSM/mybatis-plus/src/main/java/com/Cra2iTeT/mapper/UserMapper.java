package com.Cra2iTeT.mapper;

import com.Cra2iTeT.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/4/9 14:08
 */
@Mapper
@Repository     //表示持久层
public interface UserMapper extends BaseMapper<User> {
}
