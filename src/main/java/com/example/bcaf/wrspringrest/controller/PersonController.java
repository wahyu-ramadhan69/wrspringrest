package com.example.bcaf.wrspringrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcaf.wrspringrest.services.PersonService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/v1/getall")
    public ResponseEntity<Object> getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", personService.findAll());
        map.put("message", "OK");
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}