package com.Cra2iTeT.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用Mybatis获取SQLSessionFactory对象
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession连接
    public static SqlSession getSqlSession() {
        return getSqlSession(true); //事务自动提交
    }

    //获取SqlSession实例，SQLSession包含了数据库执行所有Sql命令的方法
    public static SqlSession getSqlSession(boolean flag) {
        return sqlSessionFactory.openSession(flag);
    }

}
