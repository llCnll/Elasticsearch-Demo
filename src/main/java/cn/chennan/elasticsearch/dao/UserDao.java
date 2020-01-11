package cn.chennan.elasticsearch.dao;

import cn.chennan.elasticsearch.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ChenNan
 * @date 2019-11-26 下午3:18
 **/
@Mapper
public interface UserDao {
    @Select("select * from user where id = #{id}")
    public List<User> findById(@Param("id")String id);
}
