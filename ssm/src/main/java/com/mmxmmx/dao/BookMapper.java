package com.mmxmmx.dao;

import com.mmxmmx.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(@Param("bookId") int id);
    //更新一本书
    int updateBooK(Books books);
    //查询一本书
    Books queryBookById(@Param("bookId") int id);
    //查询所有书
    List<Books> queryAllBook();
}