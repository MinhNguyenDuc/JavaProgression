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
public class Student {
    private int id;  
    @TableField
    private String name; 
    @TableField
    private String address;
    @TableField
    private String phone;
    @TableField
    @FieldToDelete
    private String rollNumber;
    private int javaMark;
    private int webMark;

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
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @FieldValueFromGetterMethod
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    @FieldValueFromGetterMethod
    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getJavaMark() {
        return javaMark;
    }

    public void setJavaMark(int javaMark) {
        this.javaMark = javaMark;
    }

    public int getWebMark() {
        return webMark;
    }

    public void setWebMark(int webMark) {
        this.webMark = webMark;
    }
    
    public Student(String name, String address, String phone, String rollNumber) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rollNumber = rollNumber;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", address=" + address + ", phone=" + phone + ", rollNumber=" + rollNumber + '}';
    }
    
    
    
}
