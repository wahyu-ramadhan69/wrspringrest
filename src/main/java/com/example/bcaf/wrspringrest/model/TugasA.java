package com.example.bcaf.wrspringrest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "ModelX")
public class TugasA {
    @Id
    @Column(name = "IDModelX", length = 30, nullable = false)
    private String idModelX;

    @Column(name = "alamat", nullable = false, columnDefinition = "NVARCHAR(255)")
    @ColumnDefault("'BELUM DI ISI'")
    private String alamat;

    @Column(name = "createdby", nullable = false)
    private Long createdBy;

    @Column(name = "createdDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "isActive")
    private Short isActive;

    @Column(name = "jenisKelamin", length = 1)
    @ColumnDefault("'P'")
    private char jenisKelamin;

    @Column(name = "MasihHidup")
    private boolean masihHidup;

    @Column(name = "modifiedby")
    private Long modifiedBy;

    @Column(name = "modifiedDate")
    @Temporal(TemporalType.TIMESTAMP)

    private Date modifiedDate;

    @Column(name = "nama", length = 40, nullable = false)
    @ColumnDefault("'SEDANG DIMINTA'")
    private String nama;

    @Column(name = "tanggalLahir", length = 10)
    private String tanggalLahir;

    public String getIdModelX() {
        return idModelX;
    }

    public void setIdModelX(String idModelX) {
        this.idModelX = idModelX;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public char getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(char jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public boolean isMasihHidup() {
        return masihHidup;
    }

    public void setMasihHidup(boolean masihHidup) {
        this.masihHidup = masihHidup;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

}
