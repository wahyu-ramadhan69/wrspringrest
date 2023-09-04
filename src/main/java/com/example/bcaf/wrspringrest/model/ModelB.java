package com.example.bcaf.wrspringrest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ModelB")
public class ModelB {
    private static final Long serializeVersion = 70002L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDModelB")
    private Long idModelB;
    @Column(name = "CreatedBy")
    private long Createdby;
    @Column(name = "createdDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "IsActive")
    private short IsActive;
    @Column(name = "ModelB", columnDefinition = "CHAR(30)")
    private String ModelB;
    @Column(name = "ModifiedBy")
    private long ModifiedBy;
    @Column(name = "ModifiedDate", columnDefinition = "CHAR(50)")
    private String ModifiedDate;
    @ManyToOne
    @JoinColumn(name = "IDModelA", foreignKey = @ForeignKey(name = "fkModelAToModelB"))
    private ModelA ModelA;

    public Long getIdModelB() {
        return idModelB;
    }

    public void setIdModelB(Long idModelB) {
        this.idModelB = idModelB;
    }

    public long getCreatedby() {
        return Createdby;
    }

    public void setCreatedby(long createdby) {
        Createdby = createdby;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public short getIsActive() {
        return IsActive;
    }

    public void setIsActive(short isActive) {
        IsActive = isActive;
    }

    public String getModelB() {
        return ModelB;
    }

    public void setModelB(String modelB) {
        ModelB = modelB;
    }

    public long getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(long modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        ModifiedDate = modifiedDate;
    }

    public com.example.bcaf.wrspringrest.model.ModelA getModelA() {
        return ModelA;
    }

    public void setModelA(com.example.bcaf.wrspringrest.model.ModelA modelA) {
        ModelA = modelA;
    }
}
