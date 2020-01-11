package cn.chennan.elasticsearch.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * Blog 文档
 * @author ChenNan
 * @date 2019-11-23 下午6:24
 **/
@Data
@Document(indexName = "blog", type = "blog") // 文档
public class EsBlog implements Serializable {
    @Id // 主键
    private String id;
    private String title;
    private String summary;
    private String content;

    private User user;

    protected EsBlog(){}

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }
}
