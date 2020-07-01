package com.mmxmmx.service;

import com.mmxmmx.dao.BookMapper;
import com.mmxmmx.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {
    //service层调Dao层，组合Dao
    private BookMapper bookMapper;
    //并为Dao层设置Set方法，用于将其托管给Spring，后面注入Spring中

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBooK(Books books) {
        return bookMapper.updateBooK(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
