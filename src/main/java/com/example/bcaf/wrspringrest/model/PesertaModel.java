package com.example.bcaf.wrspringrest.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "peserta")
public class PesertaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @NotNull(message = "Field Nama Tidak Boleh NULL")
    // @NotEmpty(message = "Field Nama Tidak Boleh Kosong")
    // @Length(min = 5, max = 15, message = "Minimal 5 maksimal 15 karakter")
    // @Email(message = "Format email tidak valid")
    // @NotBlank(message = "Field Nama Tidak boleh blank")
    // @NotNull(message = "Field Umur Wajib Diisi")
    // @NotNull(message = "Field Nilai Tidak Boleh Null")

    @NotEmpty(message = "Field Nama Tidak Boleh Kosong")
    @NotNull(message = "Field Nama Tidak Boleh NULL")
    private String nama;

    private String batch;

    private String alamat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}
