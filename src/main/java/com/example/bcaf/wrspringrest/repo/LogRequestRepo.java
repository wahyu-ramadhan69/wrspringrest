package com.example.bcaf.wrspringrest.repo;

import com.example.bcaf.wrspringrest.model.LogRequest;
import org.springframework.data.repository.CrudRepository;

/*
    Pakai CrudRepository karena table ini hanya untuk insert request yang menyebabkan ERROR !!
 */
public interface LogRequestRepo extends CrudRepository<LogRequest, Long> {

}