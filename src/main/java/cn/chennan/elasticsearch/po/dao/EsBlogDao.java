package cn.chennan.elasticsearch.po.dao;

import cn.chennan.elasticsearch.po.EsBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.jmx.export.annotation.ManagedNotification;

import java.util.List;

/**
 * @author ChenNan
 * @date 2019-11-26 下午3:18
 **/
@Mapper
public interface EsBlogDao {
    @Select("select * from blog")
    public List<EsBlog> listAll();
}
