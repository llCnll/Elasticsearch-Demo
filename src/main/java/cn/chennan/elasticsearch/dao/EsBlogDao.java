package cn.chennan.elasticsearch.dao;

import cn.chennan.elasticsearch.po.EsBlog;
import cn.chennan.elasticsearch.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ChenNan
 * @date 2019-11-26 下午3:18
 **/
@Mapper
public interface EsBlogDao {
    @Select("select * from blog")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "user", column = "user_id", javaType = User.class, one = @One(select = "cn.chennan.elasticsearch.dao.UserDao.findById"))
    })
    public List<EsBlog> listAll();
}
