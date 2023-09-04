package com.example.bcaf.wrspringrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bcaf.wrspringrest.model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
