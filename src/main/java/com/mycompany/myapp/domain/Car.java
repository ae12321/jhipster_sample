package com.mycompany.myapp.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A Car.
 */
@Entity
@Table(name = "car")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "is_4_door")
    private Boolean is4Door;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Car id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return this.carName;
    }

    public Car carName(String carName) {
        this.setCarName(carName);
        return this;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Boolean getIs4Door() {
        return this.is4Door;
    }

    public Car is4Door(Boolean is4Door) {
        this.setIs4Door(is4Door);
        return this;
    }

    public void setIs4Door(Boolean is4Door) {
        this.is4Door = is4Door;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        return id != null && id.equals(((Car) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Car{" +
            "id=" + getId() +
            ", carName='" + getCarName() + "'" +
            ", is4Door='" + getIs4Door() + "'" +
            "}";
    }
}
