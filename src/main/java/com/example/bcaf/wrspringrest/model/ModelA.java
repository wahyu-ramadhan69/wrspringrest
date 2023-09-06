package com.example.bcaf.wrspringrest.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ModelA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDModelA")
    private Long idModelA;

    @Column(name = "ModelA", columnDefinition = "CHAR(20) NOT NULL default 'Default model A'")
    private String modelA;

    @OneToMany(mappedBy = "modelA")
    private List<ModelB> listModelB;

    @Column(name = "CreatedBy", columnDefinition = "BIGINT NOT NULL default 1")
    private Long createdBy;

    @Column(name = "CreatedDate", columnDefinition = "DATETIME NOT NULL default GETDATE()")
    private Date createdDate = new Date();

    @Column(name = "ModifiedBy")
    private Long modifiedBy;

    @Column(name = "ModifiedDate", columnDefinition = "DATETIME NULL")
    private Date modifiedDate;

    @Column(name = "IsActive")
    private Byte isActive;

    public List<ModelB> getListModelB() {
        return listModelB;
    }

    public void setListModelB(List<ModelB> listModelB) {
        this.listModelB = listModelB;
    }

    public Long getIdModelA() {
        return idModelA;
    }

    public void setIdModelA(Long idModelA) {
        this.idModelA = idModelA;
    }

    public String getModelA() {
        return modelA;
    }

    public void setModelA(String modelA) {
        this.modelA = modelA;
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

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
}
