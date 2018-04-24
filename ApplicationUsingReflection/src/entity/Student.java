/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import myannotation.TableField;

/**
 *
 * @author xuanhung
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
    private String rollNumber;
    private int javaMark;
    private int sqlMark;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void printInfo() {
        System.out.println("Student id: " + this.id + "Student name: " + this.name + "Student address: " + this.address + "Student phone: " + this.phone + "Student rollnumber: " + this.rollNumber);
    }

    public boolean isValid() {
        if (name == null || name.length() <= 7) {
            return false;
        }
        if (rollNumber == null || rollNumber.length() != 8) {
            return false;
        }
        if (phone == null || phone.length() != 11) {
            return false;
        }
        if (address == null || address.length() == 0) {
            return false;
        }
        return true;
    }

    public Student(String name, String rollNumber, String address) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public Student(String name, String address, String phone, String rollNumber) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rollNumber = rollNumber;
    }

    public Student() {
    }

    public boolean save() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stt = connection.createStatement();
            stt.execute("INSERT INTO Students (name, address, phone, rollNumber) VALUES ('" + this.getName() + "', '" + this.getAddress() + "', '" + this.getPhone() + "', '" + this.getRollNumber() + "')");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
