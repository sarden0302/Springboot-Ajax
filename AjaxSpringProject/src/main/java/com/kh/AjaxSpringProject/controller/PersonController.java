package com.kh.AjaxSpringProject.controller;

import com.kh.AjaxSpringProject.dto.Person;
import com.kh.AjaxSpringProject.service.PersonService;
import com.kh.AjaxSpringProject.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    PersonController() {
        personService = new PersonServiceImpl();
    }

    /**
     * /api/person 주소로
     * DB 에서 가져온 Users 정보를 전달
     * @return List<Person>
     */
    @GetMapping("/api/person")
    public String getAllPerson() {
        return "persons";
    }
}
