/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StudentController;
import entity.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class MainThread {
    public static void main(String[] args) {
        generateMenu();
    }
    
    public static void demoArrayList(){
        ArrayList a = new ArrayList<>();
        
    }
    
    public static void generateMenu(){
        Scanner input = new Scanner(System.in);
        StudentController studentController = new StudentController();
        int choice;
        while(true){
            System.out.println("Quan Ly Sinh Vien");
            System.out.println("--------------------------------------");
            System.out.println("1. Them moi sinh vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Thoat");
            System.out.println("--------------------------------------");
            System.out.println("Nhap lua chon cua ban : ");
            choice = input.nextInt();
            switch(choice){
                case 1 : 
                    Student student = studentController.getStudentInformation();
                    System.out.println("Ban chon 1"); break;
                case 2 : System.out.println("Ban chon 2"); break;
                case 3 : break;
                default: System.out.println("Ban nhap sai vui long nhap lai");
            }
            if(choice == 3) {
                break;
            }
        }
    }
}
