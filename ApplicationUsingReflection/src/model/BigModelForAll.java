/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Student;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import myannotation.TableField;

/**
 *
 * @author nguye
 */
public class BigModelForAll<T> {

    private Class<T> clazz;

    public BigModelForAll(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> getClazz() {
        return clazz;
    }
    
    public String getTableName(){
        return this.clazz.getSimpleName() + "s";
    }
    
    public String generateField(){
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(this.clazz.getDeclaredFields().length);
        for (Field field : this.clazz.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println("Tên trường " + field.getName());
            
            if(field.isAnnotationPresent(TableField.class)){
                System.out.println("Là trường ở trong db.");
            }
            
            
//            field.getType();
        }
        return stringBuilder.toString();
    }
    public String generateValue(){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    public boolean insert(Object obj) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            //stm.execute("INSERT INTO " + getTableName() + " (name, address, phone, rollNumber) VALUES ('" + name + "', '" + address + "', '" + phone + "', '" + rollNumber + "')");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        BigModelForAll<Student> model = new BigModelForAll<>(Student.class);
        //System.out.println(model.getClazz().getSimpleName());
        model.generateField();

    }
}
