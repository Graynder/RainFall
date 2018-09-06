package com.gurdil.rainFall.dao.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "APP_RAINFALL")
public class Rainfall extends ObjectBaseDomain {

    private Integer nbMilimeters;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "positionId", referencedColumnName = "id")
    private Position position;

    public Rainfall() {
    }

    public Rainfall(Integer nbMilimeters) {
        this.nbMilimeters = nbMilimeters;
    }

    public Rainfall(Long id, int versionObject, Date creationDate, Date updateDate, Integer nbMilimeters) {
        super(id, versionObject, creationDate, updateDate);
        this.nbMilimeters = nbMilimeters;
    }

    public Integer getNbMilimeters() {
        return nbMilimeters;
    }

    public void setNbMilimeters(Integer nbMilimeters) {
        this.nbMilimeters = nbMilimeters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rainfall)) return false;
        Rainfall rainfall = (Rainfall) o;
        return id != null && id.equals(((Rainfall) o).id);
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rainfall{");
        sb.append(super.toString());
        sb.append("nbMilimeters=").append(nbMilimeters);
        sb.append('}');
        return sb.toString();
    }
}
