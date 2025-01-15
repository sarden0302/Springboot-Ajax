package com.kh.AjaxSpringProject.mapper;

import com.kh.AjaxSpringProject.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUsers();

    User getUserId(int id);
}
