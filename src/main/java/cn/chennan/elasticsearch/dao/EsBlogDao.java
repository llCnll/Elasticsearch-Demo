package cn.chennan.elasticsearch.dao;

import cn.chennan.elasticsearch.po.EsBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
