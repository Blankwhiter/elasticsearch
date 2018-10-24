package com.elasticsearch.springboot;

import com.elasticsearch.springboot.po.Book;
import com.elasticsearch.springboot.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {


    @Autowired
    BookRepository bookRepository;

    /**
     * 创建索引
     */
    @Test
    public void createIndex(){
        Book book = new Book();
        book.setId(1);
        book.setAuthor("周志明");
        book.setBookName("深入理解Java虚拟机_JVM高级特性与最佳实践");
        book.setDesc("Java虚拟机，最佳实践。。。。");
        bookRepository.save(book);
    }

    /**
     * 搜索索引
     */
    @Test
    public void searchIndex(){
        Optional<Book> optionalBook = bookRepository.findById(1);
        System.out.println(optionalBook.get().toString());
    }


    @Test
    public void contextLoads() {
    }

}
