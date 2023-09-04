package com.example.bcaf.wrspringrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bcaf.wrspringrest.model.Person;
import com.example.bcaf.wrspringrest.repo.PersonRepo;

@Transactional
@Service
public class PersonService {

    private PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> findAll() {
        return personRepo.findAll();
    }

}
