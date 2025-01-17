package com.kh.AjaxSpringProject.controller;

import com.kh.AjaxSpringProject.dto.Person;
import com.kh.AjaxSpringProject.service.PersonService;
import com.kh.AjaxSpringProject.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonAjaxController {
    @Autowired
    private PersonService personService;

    PersonAjaxController() {
        personService = new PersonServiceImpl();
    }

    @GetMapping("/get/persons")
    public List<Person> getPersons() {
        return personService.getAllPerson();
    }
}
