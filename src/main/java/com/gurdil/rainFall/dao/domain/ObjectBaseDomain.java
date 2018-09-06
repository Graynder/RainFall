package com.gurdil.rainFall.dao.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
public class ObjectBaseDomain implements Serializable {

    private static final long serialVersionUID = 2284252532274015507L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @JsonIgnore
    @Version
    protected int versionObject;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    protected Date creationDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    protected Date updateDate;

    public ObjectBaseDomain() {
        super();
    }

    public ObjectBaseDomain(Long id, int versionObject, Date creationDate, Date updateDate) {
        super();
        this.id = id;
        this.versionObject = versionObject;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersionObject() {
        return versionObject;
    }

    public void setVersionObject(int versionObject) {
        this.versionObject = versionObject;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @PrePersist
    public void prePersist() {
        creationDate = Calendar.getInstance().getTime();
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = Calendar.getInstance().getTime();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("id=");
        sb.append(id);
        sb.append(", versionObject=").append(versionObject);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", ");
        return sb.toString();
    }
}