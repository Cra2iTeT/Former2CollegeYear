package com.Cra2iTeT.dao;

import com.Cra2iTeT.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBook(@Param("bookID") int bookID);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookByID(@Param("bookID") int bookID);

    //查询全部的书
    List<Books> queryAllBook();

    //根据名字查询书籍
    Books queryBookByName(String bookName);
}
