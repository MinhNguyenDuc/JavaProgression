/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import annotation.FieldToDelete;
import annotation.FieldValueFromGetterMethod;
import annotation.TableField;

/**
 *
 * @author nguye
 */
public class Customer {
    private int id;
    @TableField
    private String name; 
    @TableField
    private String phone;
    @FieldToDelete
    @TableField
    private String customerNumber;
    private int balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @FieldValueFromGetterMethod
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @FieldValueFromGetterMethod
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @FieldValueFromGetterMethod
    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
    
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Customer(String name, String phone, String customerNumber, int balance) {
        this.name = name;
        this.phone = phone;
        this.customerNumber = customerNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", phone=" + phone + ", customerNumber=" + customerNumber + ", balance=" + balance + '}';
    }
    
    
}
