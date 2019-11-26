package cn.chennan.elasticsearch.repository;

import cn.chennan.elasticsearch.po.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * EsBlog Repository 接口
 * @author ChenNan
 * @date 2019-11-23 下午6:30
 **/
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
    /**
     * 分页查询博客(去重)
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
     Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
