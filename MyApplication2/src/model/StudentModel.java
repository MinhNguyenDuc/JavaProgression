/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Student;
import err.SoiEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author nguye
 */
public class StudentModel {
    
    public boolean insert(Student student){
        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            String sql = "INSERT INTO Students (name, address, phone, rollNumber) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getAddress());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getRollNumber());
            ps.execute();
            //stm.execute("INSERT INTO Students (name, address, phone, rollNumber) VALUES ('"+student.getName()+"', '"+student.getAddress()+"', '"+student.getPhone()+"', '"+student.getRollNumber()+"')");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean update(int id, String name, String address, String phone, String rollNumber) throws SQLException, SoiEx{
        if(false){           
            throw new SoiEx();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            stm.execute("UPDATE students SET name = '" + name +"',"
                    + " address = '" + address +"',"
                    + "phone = '" + phone +"',"
                    + "rollNumber = '" + rollNumber +"'  WHERE id = " + id);
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Student> getList(){
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM students");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String rollNumber = rs.getString("rollNumber");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Student st = new Student(name, address, phone, rollNumber);
                listStudent.add(st);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listStudent;
    }
    
    
    //Hàm này nhận tham số đầu vào là id của Student
    //Trả về 1 đối tượng Student nếu trong database tồn tại bản ghi
    //với id truyền vào. Trong trường hợp không tồn tại trong db
    //thì trả về null
    public Student getById(int id){
        Student st = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM students WHERE id = " + id);
            if(rs.next()){
                String name = rs.getString("name");
                String rollNumber = rs.getString("rollNumber");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                st = new Student(name, address, phone, rollNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
    
    public ArrayList<Student> searchByName(String name){
        ArrayList<Student> listStudentSearchByName = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM students WHERE name LIKE '%" + name +"%'");
            if(rs.next()){
                String rollNumber = rs.getString("rollNumber");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Student st = new Student(name, address, phone, rollNumber);
                listStudentSearchByName.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStudentSearchByName;
    }
    
    public boolean checkExistRollNumber(String rollNumber){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM students WHERE rollNumber = " + rollNumber);
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int id){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8", "root", "");
            Statement stm = connection.createStatement();
            stm.execute("DELETE FROM students WHERE id = "+ id +"");
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static void printClassName(Student student){
        String className = student.getClass().getSimpleName();
        System.out.println(className);
    }
    
    //Dung StringBuilder de nhanh hon va tiet kiem bo nho
    public static void demoStringJava(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Minh ");
        stringBuilder.append("Nguyen");
        System.out.println(stringBuilder);
    }
    
    public static void main(String[] args) {
//        StudentModel studentModel = new StudentModel();
//        if(studentModel.delete(7)){
//            System.out.println("Xóa thành công");
//        }
//        ArrayList<Student> listStudent = studentModel.getList();
//        for (int i = 0; i < listStudent.size(); i++) {
//            Student student = listStudent.get(i);
//            System.out.printf("%15s %15s %15s %15s \n", student.getRollNumber(), student.getName(),
//                    student.getPhone(), student.getAddress());
//        }
        Student student = new Student("Minh", "ASC", "Ha noi");
        printClassName(student);
        demoStringJava();
    }
}
