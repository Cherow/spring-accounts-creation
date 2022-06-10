package com.kcbgroup.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class AccountModel {




    private double balance;
//    @SequenceGenerator(
//            name = "customer_sequence",
//            sequenceName = "customer_sequence",
//            allocationSize = 200
    //)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="system-uuid"
    )
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Id
    private  String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    public CustomerModel customerModel;

    public AccountModel() {
    }

    public AccountModel(double balance, String accountNumber, CustomerModel customerModel) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.customerModel = customerModel;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }
}
