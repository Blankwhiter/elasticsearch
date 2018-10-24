package com.elasticsearch.jest;

import com.elasticsearch.jest.po.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JestApplicationTests {

    /**
     * 引入
     */
    @Autowired
    JestClient jestClient;


    /**
     * 创建索引
     */
    @Test
    public void createIndex() {
        Article article = new Article();
        article.setId(1);
        article.setAuthor("海子");
        article.setTitle("面朝大海，春暖花开");
        article.setContent("从明天起，做一个幸福的人。。。。。。");

        Index index = new Index.Builder(article).index("article").type("poetry").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 搜索索引
     * @throws IOException
     */
    @Test
    public void searchIndex() throws IOException {
        StringBuffer query  = new StringBuffer("{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"明天\"\n" +
                "        }\n" +
                "    }\n" +
                "}");
        Search search = new Search.Builder(query.toString()).addIndex("article").addType("poetry").build();
        SearchResult result = jestClient.execute(search);
        System.out.println(result+" : "+result.getJsonString());
    }


    @Test
    public void contextLoads() {
    }

}
