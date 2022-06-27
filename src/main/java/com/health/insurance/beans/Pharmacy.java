package com.health.insurance.beans;

import javax.persistence.*;

@Entity
@Table(name="pharmacy")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="contract")
    private String contract;
    @Column(name="email")
    private String email;
    @Column(name="website")
    private String website;
    @Column(name="address")
    private String address;

    public Pharmacy() {
    }

    public Pharmacy(String name, String contract, String email, String website, String address) {
        this.name = name;
        this.contract = contract;
        this.email = email;
        this.website = website;
        this.address = address;
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

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
