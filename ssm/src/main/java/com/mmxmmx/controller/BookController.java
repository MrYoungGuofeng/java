package com.mmxmmx.controller;

import com.mmxmmx.pojo.Books;
import com.mmxmmx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller层调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍，并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> bookslist = bookService.queryAllBook();
        model.addAttribute("list",bookslist);
        return "allBook";
    }
    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook==>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook"; //不带数据的返回使用重定向
    }
}
