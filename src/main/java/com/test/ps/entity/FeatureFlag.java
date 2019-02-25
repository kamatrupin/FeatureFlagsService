package com.test.ps.entity;

import javax.persistence.*;

@Entity
public class FeatureFlag {

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @Column
    private String country;
    @Column
    private int value;

    public FeatureFlag() {}

    public FeatureFlag(String country, int value) {
        this.country = country;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
