package com.kh.AjaxSpringProject.mapper;

import com.kh.AjaxSpringProject.dto.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    List<Person> getAllPerson();
}
