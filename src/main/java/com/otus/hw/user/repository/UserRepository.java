package com.otus.hw.user.repository;

import com.otus.hw.user.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.UUID;

@Mapper
public interface UserRepository {

    @Results(value = {
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "secondName", column = "second_name")
    })
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(@Param("id") UUID id);

    @Results(value = {
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "secondName", column = "second_name")
    })
    @Select("SELECT * FROM users WHERE first_name = #{first_name} AND second_name = #{second_name}")
    User findByFirstNameAndSecondName(@Param("first_name") String firstName, @Param("second_name") String secondName);

    @Insert("Insert into users(id, first_name, second_name, birthday, biography, city, password) " +
            "values (#{id, javaType=java.util.UUID, jdbcType=OTHER, typeHandler=com.otus.hw.common.mybatis.UuidTypeHandler}, #{firstName}, #{secondName}, #{birthday}, #{biography}, #{city}, #{password})")
    void save(User user);
}
