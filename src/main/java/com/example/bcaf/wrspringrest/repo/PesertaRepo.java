package com.example.bcaf.wrspringrest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bcaf.wrspringrest.model.PesertaModel;

public interface PesertaRepo extends JpaRepository<PesertaModel, Integer> {
    public List<PesertaModel> findBynamaContainsAndBatchContains(String n, String b);

}
