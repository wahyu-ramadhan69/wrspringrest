package com.example.bcaf.wrspringrest.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ModelC")
public class ModelC {

    private static final Long serializeVersion = 70003L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDModelC")
    private Long idmodelc;

    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "isActive")
    private Short isActive;
    @Column(name = "ModelC", nullable = false, columnDefinition = "CHAR(20)")
    private String modelc;

    @Column(name = "ModifiedBy")
    private Long modifiedby;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ModifiedDate;

    @ManyToMany
    @JoinTable(name = "MapModelBModelC", joinColumns = {
            @JoinColumn(name = "IDModelC", referencedColumnName = "IDModelC", foreignKey = @ForeignKey(name = "fkMapToModelC")) }, inverseJoinColumns = {
                    @JoinColumn(name = "IDModelB", referencedColumnName = "IDModelB", foreignKey = @ForeignKey(name = "fkMapToModelB")) }, uniqueConstraints = @UniqueConstraint(columnNames = {
                            "IDModelC", "IDModelB" }))
    private List<ModelB> ModelB;

    public Long getIdmodelc() {
        return idmodelc;
    }

    public void setIdmodelc(Long idmodelc) {
        this.idmodelc = idmodelc;
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

    public String getModelc() {
        return modelc;
    }

    public void setModelc(String modelc) {
        this.modelc = modelc;
    }

    public Long getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        ModifiedDate = modifiedDate;
    }

    public List<com.example.bcaf.wrspringrest.model.ModelB> getModelB() {
        return ModelB;
    }

    public void setModelB(List<com.example.bcaf.wrspringrest.model.ModelB> modelB) {
        ModelB = modelB;
    }
}