package com.Cra2iTeT.service;

import com.Cra2iTeT.dao.BookMapper;
import com.Cra2iTeT.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {
    //service调dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBook(int bookID) {
        return bookMapper.deleteBook(bookID);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookByID(int bookID) {
        return bookMapper.queryBookByID(bookID);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
