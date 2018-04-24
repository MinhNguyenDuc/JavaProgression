/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import entity.Student;
import java.util.Scanner;
/**
 *
 * @author nguye
 */
public class StudentController {
    public Student getStudentInformation(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên : ");
        String name = input.next();
        System.out.println("Nhập địa chỉ sinh viên : ");
        String address = input.next();
        System.out.println("Nhập số điện thoại : ");
        String phone = input.next();
        System.out.println("Nhập roll number : ");
        String rollNumber = input.next();
        Student s = new Student(name, phone, address, rollNumber);
        return s;
    }
}
