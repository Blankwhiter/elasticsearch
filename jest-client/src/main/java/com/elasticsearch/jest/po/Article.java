package com.elasticsearch.jest.po;

import io.searchbox.annotations.JestId;
import lombok.Data;

/**
 * 文章实体类
 */
@Data
public class Article {

    /**
     * 主键
     */
    @JestId
    private Integer id;
    /**
     * 作者
     */
    private String author;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;


}
