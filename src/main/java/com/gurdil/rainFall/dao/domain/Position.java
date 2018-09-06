package com.gurdil.rainFall.dao.domain;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;


@Entity(name = "APP_POSITION")
public class Position extends ObjectBaseDomain {

    private String longitude;
    private String latitude;

    public Position() {
    }

    public Position(String longitude, String latitude, List<Rainfall> rainfalls) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Position(Long id, int versionObject, Date creationDate, Date updateDate, String longitude, String latitude, List<Rainfall> rainfalls) {
        super(id, versionObject, creationDate, updateDate);
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Position{");
        sb.append(super.toString());
        sb.append("longitude='").append(longitude).append('\'');
        sb.append(", latitude='").append(latitude).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
