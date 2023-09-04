package com.example.bcaf.wrspringrest.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ModelA")
public class ModelA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDModelA")
    private Long idModelA;

    @Column(name = "CreateBy")
    private Long createby;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "isActive")
    private Short isActive;
    @Column(name = "ModelA", nullable = false, columnDefinition = "CHAR(20)")
    private String modela;
    @Column(name = "ModifiedfBy")
    private Long modifiedby;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ModifiedDate;
    @OneToMany(mappedBy = "ModelA")
    private List<ModelB> listModelB;

    public Long getIdModelA() {
        return idModelA;
    }

    public void setIdModelA(Long idModelA) {
        this.idModelA = idModelA;
    }

    public Long getCreateby() {
        return createby;
    }

    public void setCreateby(Long createby) {
        this.createby = createby;
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

    public String getModela() {
        return modela;
    }

    public void setModela(String modela) {
        this.modela = modela;
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

    public List<ModelB> getListModelB() {
        return listModelB;
    }

    public void setListModelB(List<ModelB> listModelB) {
        this.listModelB = listModelB;
    }
}
