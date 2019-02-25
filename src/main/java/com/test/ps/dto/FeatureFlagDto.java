package com.test.ps.dto;

import javax.validation.constraints.NotNull;

public class FeatureFlagDto {

    @NotNull
    private Integer id;
    @NotNull
    private String country;
    @NotNull
    private int value;
    private boolean checked;    // This property is just to map the checkbox on UI

    public FeatureFlagDto() {}

    public FeatureFlagDto(String country, int value) {
        this.country = country;
        this.value = value;
    }

    public FeatureFlagDto(Integer id, String country, int value) {
        this.id = id;
        this.country = country;
        this.value = value;
        this.checked = value == 1 ? true : false;
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
