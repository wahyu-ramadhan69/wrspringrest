package com.example.bcaf.wrspringrest.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ModelC {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "IDModelC")
        private Long idModelC;

        @Column(name = "ModelC", columnDefinition = "CHAR(25) NOT NULL default 'Default Model C' ")
        private String modelC;

        @ManyToMany
        @JoinTable(name = "MapModelBModelC", joinColumns = {
                        @JoinColumn(name = "IDModelC", referencedColumnName = "IDModelC", foreignKey = @ForeignKey(name = "fkMapToModelC")) }, inverseJoinColumns = {
                                        @JoinColumn(name = "IDModelB", referencedColumnName = "IDModelB", foreignKey = @ForeignKey(name = "fkMapToModelB")),
                        }, uniqueConstraints = @UniqueConstraint(columnNames = {
                                        "IDModelB", "IDModelC" }))
        private List<ModelB> listModelB;

        @Column(name = "CreatedBy", columnDefinition = "BIGINT NOT NULL default 1")
        private Long createdBy;

        @Column(name = "CreatedDate", columnDefinition = "DATETIME NOT NULL default 'GETDATE()'")
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

        public Long getIdModelC() {
                return idModelC;
        }

        public void setIdModelC(Long idModelC) {
                this.idModelC = idModelC;
        }

        public String getModelC() {
                return modelC;
        }

        public void setModelC(String modelC) {
                this.modelC = modelC;
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
