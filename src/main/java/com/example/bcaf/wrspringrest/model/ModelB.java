package com.example.bcaf.wrspringrest.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ModelB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDModelB")
    private Long idModelB;

    @Column(name = "ModelB", columnDefinition = "CHAR(30) NOT NULL default 'Default Model B' ")
    private String modelB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDModelA", foreignKey = @ForeignKey(name = "fk_modelB_modelA", foreignKeyDefinition = "FOREIGN KEY ([IDModelA]) REFERENCES [ujianSB].[ModelA] ([IDModelA]) ON DELETE SET NULL ON UPDATE SET NULL"))
    private ModelA modelA;

    @ManyToMany(mappedBy = "listModelB")
    private List<ModelC> listModelC;

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

    public ModelA getModelA() {
        return modelA;
    }

    public void setModelA(ModelA modelA) {
        this.modelA = modelA;
    }

    public List<ModelC> getListModelC() {
        return listModelC;
    }

    public void setListModelC(List<ModelC> listModelC) {
        this.listModelC = listModelC;
    }

    public Long getIdModelB() {
        return idModelB;
    }

    public void setIdModelB(Long idModelB) {
        this.idModelB = idModelB;
    }

    public String getModelB() {
        return modelB;
    }

    public void setModelB(String modelB) {
        this.modelB = modelB;
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
