package com.test;

import com.dao.BookDAO;
import com.dto.BookDto;
import com.model.Book;
import com.service.BookService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by C.A.O on 2018/8/10.
 */
public class TestBookService {

    static BookService bookservice;

    SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void before(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        bookservice=ctx.getBean(BookService.class);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books=bookservice.getAllBooks();
        assertNotNull(books);
    }

    @Test
    public void testGetAllBooksByIds() {
        BookDto bookDto = new BookDto();
        bookDto.setId(2);
        List<Integer> idList = new ArrayList<Integer>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        bookDto.setIdList(idList);

        List<Book> books=bookservice.getAllBooksByIds(bookDto);
        assertNotNull(books);
    }

    @Test
    public void testAdd() {
        Book entity=new Book(0, "Hibernate 第七版", 78.1, new Date());
        try {
            assertEquals(1, bookservice.add(entity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteInt() {
        assertEquals(1, bookservice.delete(9));
    }

    @Test
    public void testDeleteStringArray() {
        String[] ids={"7","11","12"};
        assertEquals(3, bookservice.delete(ids));
    }

    @Test
    public void testUpdate() {
        Book entity=new Book(7, "Hibernate 第二版", 79.1, new Date());
        try {
            assertEquals(1, bookservice.update(entity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBookById()
    {
        assertNotNull(bookservice.getBookById(1));
    }

    @Test
    public void testAddDouble(){
        //因为书名相同，添加第二本会失败，用于测试事务
        Book entity1=new Book(0, "Hibernate 第八版", 78.1, new Date());
        Book entity2=new Book(0, "Hibernate 第八版", 78.1, new Date());
        assertEquals(2, bookservice.add(entity1, entity2));
    }


    @Test
    public void testAdd2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookDAO bookMapper = sqlSession.getMapper(BookDAO.class);
            bookMapper.getAllBooks();
            sqlSession.commit();//这里一定要提交，不然数据进不去数据库中
        } finally {
            sqlSession.close();
        }
    }
}
