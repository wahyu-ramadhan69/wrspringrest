package com.example.bcaf.wrspringrest.repo;

import com.example.bcaf.wrspringrest.model.KategoriBarang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriBarangRepo extends JpaRepository<KategoriBarang, Long> {

    public Page<KategoriBarang> findByNamaKategoriBarangContains(Pageable p, String val);

}
