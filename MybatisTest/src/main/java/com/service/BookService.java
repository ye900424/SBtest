package com.service;

import com.dao.BookDAO;
import com.dto.BookDto;
import com.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by C.A.O on 2018/8/10.
 */
@Service
public class BookService {

    //    @Resource
    @Autowired
    BookDAO bookDAO;

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public List<Book> getAllBooksByIds(BookDto bookDto) {
        return bookDAO.getAllBooksByIds(bookDto);
    }

    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }

    public int add(Book entity) throws Exception {
        if (entity.getTitle() == null || entity.getTitle().equals("")) {
            throw new Exception("书名必须不为空");
        }
        return bookDAO.add(entity);
    }

    @Transactional
    public int add(Book entity1, Book entityBak) {
        int rows = 0;
        rows = bookDAO.add(entity1);
        rows = bookDAO.add(entityBak);
        return rows;
    }

    public int delete(int id) {
        return bookDAO.delete(id);
    }

    /**
     * 多删除
     */
    public int delete(String[] ids) {
        int rows = 0;
        for (String idStr : ids) {
            int id = Integer.parseInt(idStr);
            rows += delete(id);
        }
        return rows;
    }

    public int update(Book entity) {
        return bookDAO.update(entity);
    }

}
