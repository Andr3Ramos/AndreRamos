package com.example.JpaExercise.Model;

public class Company {

    private long Id;
    private String city;
    private String state;
    private String zip;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String country;

}
