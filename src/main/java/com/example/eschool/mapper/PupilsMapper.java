package com.example.eschool.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.example.eschool.model.Pupil;

@Mapper
@Component
public interface PupilsMapper {
	
	@Select("select * from pupils")
	List<Pupil> findAll();
	
	@Insert("insert into pupils(firstName,lastName,schoolClass) values(#{firstName},#{lastName},#{schoolClass})")
    void insert(Pupil pupil);
	
	@Delete("delete from pupils where id=#{id}")
	void deleteById(Long id);
	
}
