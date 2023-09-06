package com.example.bcaf.wrspringrest.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class KategoriBarangDTO {

    private Long idKategoriBarang;// idKategoriBarang
    @NotNull
    @NotBlank
    @Length
    @NotEmpty
    @Email
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String namaKategoriBarang;

    private Long getIdKategoriBarang() {
        return idKategoriBarang;
    }

    public void setIdKategoriBarang(Long idKategoriBarang) {
        this.idKategoriBarang = idKategoriBarang;
    }

    public String getNamaKategoriBarang() {
        return namaKategoriBarang;
    }

    public void setNamaKategoriBarang(String namaKategoriBarang) {
        this.namaKategoriBarang = namaKategoriBarang;
    }
}
