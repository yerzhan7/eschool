package com.example.eschool.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.example.eschool.model.User;

@Mapper
@Component
public interface UsersMapper {
	
	@Insert("insert into users(username,password) values(#{username},#{password})")
	void insert(User user);
	
	@Select("select * from users where username = #{username}")
	User findByUsername(String username);
	
}
