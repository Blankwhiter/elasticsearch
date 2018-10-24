package com.elasticsearch.springboot.po;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "kind",type = "book")
public class Book {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 作者
     */
    private String author;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 描述
     */
    private String desc;
}
