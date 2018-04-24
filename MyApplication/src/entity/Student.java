/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author nguye
 */
public class Student {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String rollNumber;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Student(String name, String phone, String address, String rollNumber) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rollNumber = rollNumber;
    }

    public void printInfomation() {
        System.out.println("Student{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", rollNumber=" + rollNumber + '}'); 
    }
    
    public boolean isValid(){
        if(name == null || name.length() <= 7){
            return false;
        }
        if(rollNumber == null || rollNumber.length() != 8){
            return false;
        }
        if(address == null || address.length() == 0){
            return false;
        }
        return true;
    }
}
