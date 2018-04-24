/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anotherdemo;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class Employee {

    private long id;
    private String name;
    private String email;
    private String phone;
    private long birthDay;
    private String address;
    private int workingHours;
    private int salaryPerHour;
    private Date joinDate;
    private int status;

    public Employee(String name, String email) {
        this.id = System.currentTimeMillis();
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(long birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", birthDay=" + birthDay + ", address=" + address + ", workingHours=" + workingHours + ", salaryPerHour=" + salaryPerHour + ", joinDate=" + joinDate + ", status=" + status + '}';
    }
    
}
