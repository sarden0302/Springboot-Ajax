package com.kh.AjaxSpringProject.service;

import com.kh.AjaxSpringProject.dto.Person;
import com.kh.AjaxSpringProject.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public List<Person> getAllPerson() {
        return personMapper.getAllPerson();
    }

    @Override
    public Person getPersonById(int id) {
        return personMapper.getPersonById(id);
    }
}
