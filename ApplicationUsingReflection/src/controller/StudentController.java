/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author xuanhung
 */
public class StudentController {
        
    private ArrayList<Student> listStudent;
    
    public void addStudent(Student st){
        if(listStudent == null){
            listStudent = new ArrayList<>();
        }
        listStudent.add(st);
    }
    
    public Student getStudentInformation() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Vui lòng nhập tên sinh viên: ");
        String name = sc1.nextLine();
        System.out.println("Vui lòng nhập mã sinh viên: ");
        String rollNumber = sc1.nextLine();
        System.out.println("Vui lòng nhập địa chỉ");
        String address = sc1.nextLine();
        System.out.println("Vui lòng nhập số điện thoại :");
        String phone = sc1.nextLine();
        Student student = new Student(name, address, phone, rollNumber);
        return student;
    }

    public ArrayList<Student> getListStudent() {
        if(listStudent == null){
            listStudent = new ArrayList<>();
        }
        return listStudent;
    }
    
    public void printListStudent(ArrayList<Student> listStudent){
        for (int i = 0; i < listStudent.size(); i++) {
            Student student = listStudent.get(i);
            System.out.printf("%15s %15s %15s %15s \n", student.getRollNumber(), student.getName(),
                    student.getPhone(), student.getAddress());
        }
    }
}
