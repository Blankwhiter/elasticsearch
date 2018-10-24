package com.elasticsearch.springboot.repository;

import com.elasticsearch.springboot.po.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
