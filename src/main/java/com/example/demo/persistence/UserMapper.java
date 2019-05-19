package com.example.demo.persistence;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from T_USER ")
    List<User> list();

    @Select("select * from T_USER where id=#{id}")
    User getById(String id);

    @Insert("insert into T_USER(id, name, city, address) values(#{id}, #{name}, #{city}, #{address})")
    void create(User user);
}
