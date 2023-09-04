package com.example.bcaf.wrspringrest.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CalonPeserta {
    @NotNull(message = "Field Nama Tidak Boleh NULL")
    @NotEmpty(message = "Field Nama Tidak Boleh Kosong")
    @Length(min = 5, max = 15, message = "Minimal 5 maksimal 15 karakter")
    @Email(message = "Format email tidak valid")
    @NotBlank(message = "Field Nama Tidak boleh blank")
    private String nama;
    @NotNull(message = "Field Umur Wajib Diisi")
    private Integer umur;
    @NotNull(message = "Field Umur Wajib Diisi")
    private Integer nilai;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Integer getNilai() {
        return nilai;
    }

    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }

}
