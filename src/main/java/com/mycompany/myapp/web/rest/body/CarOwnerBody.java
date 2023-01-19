package com.mycompany.myapp.web.rest.body;

import java.io.Serializable;

// CarOwnerBody demo ii
public class CarOwnerBody implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private Long carId;
    private String carName;
    private Boolean carIs4Door;

    private Long ownerId;
    private String ownerName;
    private Integer ownerAge;

    public CarOwnerBody() {}

    public static CarOwnerBody clone(CarOwnerBody src) {
        CarOwnerBody result = new CarOwnerBody();
        result.setCarId(src.getCarId());
        result.setCarName(src.getCarName());
        result.setCarIs4Door(src.getCarIs4Door());
        result.setOwnerId(src.getOwnerId());
        result.setOwnerName(src.getOwnerName());
        result.setOwnerAge(src.getOwnerAge());
        return result;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Boolean getCarIs4Door() {
        return carIs4Door;
    }

    public void setCarIs4Door(Boolean carIs4Door) {
        this.carIs4Door = carIs4Door;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(Integer ownerAge) {
        this.ownerAge = ownerAge;
    }
}
