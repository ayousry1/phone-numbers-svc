package com.jumia.phonenumber.resources.customer.entity;

public class CustomerModel {
    private int id;

    private String name;

    private String phone;

    private String status;

    private String Country;

    public CustomerModel() {
    }

    public CustomerModel(int id, String name, String phone, String status, String country) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.status = status;
        Country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
