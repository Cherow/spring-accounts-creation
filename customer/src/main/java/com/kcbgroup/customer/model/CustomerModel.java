package com.kcbgroup.customer.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(
//            name = "sequence",
//            sequenceName = "sequence",
//            allocationSize = 200
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "sequence"
//    )
//    @Column(insertable = false, updatable = false)
    private int customerID;
    private String name;
    private String occupation;
    private String  phoneNumber;
    private String gender;
    @OneToMany(mappedBy = "customerModel")
    private List<AccountModel> accountModel;

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + customerID +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public CustomerModel() {
    }

    public CustomerModel(int customerID, String name, String occupation,
                         String phoneNumber, String gender) {
        this.customerID = customerID;
        this.name = name;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int id) {
        this.customerID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<AccountModel> getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(List<AccountModel> accountModel) {
        this.accountModel = accountModel;
    }
}
