package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.Books;
import com.Cra2iTeT.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调用service
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBooks")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();

        model.addAttribute("list", list);

        return "allBooks";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    //添加书籍
    @RequestMapping("/addBook")
    public String addBook(Books book) {
        bookService.addBook(book);
        return "redirect:/book/allBooks";
    }

    //跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int bookID) {
        System.out.println("得到的bookID：" + bookID);
        System.out.println("查询到的book：" + bookService.queryBookByID(bookID));
        System.out.println("===========");
        model.addAttribute("book", bookService.queryBookByID(bookID));
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        System.out.println("===========");
        bookService.updateBook(book);
        model.addAttribute("book", bookService.queryBookByID(book.getBookID()));
        return "redirect:/book/allBooks";
    }

    //删除书籍
    @RequestMapping("/del/{bookID}")
    public String delBooksByID(@PathVariable("bookID") int bookID) {
        bookService.deleteBook(bookID);
        return "redirect:/book/allBooks";
    }

    //按名字查询书籍
    @RequestMapping("/queryBookByName")
    public String queryBookByName(Model model, String bookName) {
        System.out.println("后端得到的bookName：" + bookName);
        System.out.println("=============");

        Books book = bookService.queryBookByName(bookName);

        if (book == null) {
            System.out.println("未查到");
            System.out.println("=========");
            model.addAttribute("error", "未查到");
            model.addAttribute("book", bookService.queryAllBook());
        } else {
            System.out.println(book);
            System.out.println("=========");
            List<Books> list = new ArrayList<>();
            list.add(book);
            model.addAttribute("book", list);
        }
        return "/queryBookByName";
    }
}