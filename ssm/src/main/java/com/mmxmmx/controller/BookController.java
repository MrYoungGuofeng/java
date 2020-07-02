package com.mmxmmx.controller;

import com.mmxmmx.pojo.Books;
import com.mmxmmx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.ArrayList;
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
    //跳转到修改页面
    @RequestMapping("/toUpadte")
    public String toUpdatePaper(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QueryBook",books);
        return "updateBook";
    }
    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updatebook===》"+books);
        bookService.updateBook(books);
        //因为修改时没有添加bookid，而SQL语句修改需要用id作为条件。此时可以在JSP中使用隐藏域input提交
        return "redirect:/book/allBook";
    }
    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    //使用RestFull风格
    public String deleteBook(@PathVariable("bookId") int id){
        System.out.println("deletebook===》"+id);
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
    //查询书籍
    //query是form表单提交的地址。queryBookName是查询的内容，还需要一个Model
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        //调用service层查询书籍
        Books books = bookService.queryBookByName(queryBookName);
        //将查询出来的book添加到list中
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if(books==null){
            list=bookService.queryAllBook();
            model.addAttribute("error","未查到对应书籍");
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
