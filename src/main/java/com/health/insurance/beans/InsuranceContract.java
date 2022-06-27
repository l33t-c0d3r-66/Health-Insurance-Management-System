package com.health.insurance.beans;

import javax.persistence.*;

@Entity
@Table(name="insuranceContract")
public class InsuranceContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="term")
    private String term;
    @Column(name="contractAmount")
    private String contractAmount;
    @Column(name="faceAmount")
    private String faceAmount;
    @Column(name="interest")
    private String interest;

    public InsuranceContract() {
    }

    public InsuranceContract(String name, String term, String contractAmount, String faceAmount, String interest) {
        this.name = name;
        this.term = term;
        this.contractAmount = contractAmount;
        this.faceAmount = faceAmount;
        this.interest = interest;
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getFaceAmount() {
        return faceAmount;
    }

    public void setFaceAmount(String faceAmount) {
        this.faceAmount = faceAmount;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "InsuranceContract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", term='" + term + '\'' +
                ", contractAmount='" + contractAmount + '\'' +
                ", faceAmount='" + faceAmount + '\'' +
                ", interest='" + interest + '\'' +
                '}';
    }
}
