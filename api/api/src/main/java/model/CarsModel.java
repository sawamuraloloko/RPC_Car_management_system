package model;

import java.io.Serializable;

public class CarsModel implements Serializable {
    private String cid;
    private String city;
    private String uid;
    private String color;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwner() {
        return uid;
    }

    public void setOwner(String owner) {
        this.uid = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
