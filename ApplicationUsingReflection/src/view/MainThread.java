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
import model.StudentModel;

/**
 *
 * @author xuanhung
 */
public class MainThread {

    public static void main(String[] args) {
        generateMenu();
    }
    
    public static void demoArrayList(){
        ArrayList<Student> listStudent = new ArrayList<>();
//        listStudent.add(new Student("Hung", "A0012"));
//        listStudent.add(new Student("Minh", "A0013"));
        
        for (int i = 0; i < listStudent.size(); i++) {
            Student student = listStudent.get(i);
            System.out.println(student.getName());
        }
    }
    
    public static void testModel(){
        StudentModel stModel = new StudentModel();
        Student st = new Student();
        st.setName("Huong");
        st.setAddress("Hung yen");
        st.setPhone("123456");
        st.setRollNumber("1198");
        stModel.insert(st);
    }
    
    public static void addInfoIntoDatabase(Student student){
        StudentModel studentModel = new StudentModel();
        if(studentModel.insert(student) == true){
            System.out.println("Thêm sinh viên thành công");
        }
    }
    
    public static ArrayList<Student> getListStudentInfo(){
        StudentModel studentModel = new StudentModel();
        return studentModel.getList();
    }
    
    public static void generateMenu(){
        StudentController studentController = new StudentController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Quản lý sinh viên");
            System.out.println("========================");
            System.out.println("1. Thêm mới.");
            System.out.println("2. Hiển thị danh sách.");
            System.out.println("3. Chỉnh sửa thông tin sinh viên.");
            System.out.println("4. Xóa sinh viên.");
            System.out.println("5. Thoát.");
            System.out.println("Vui lòng nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Student student = studentController.getStudentInformation();
                    addInfoIntoDatabase(student);
                    break;
                case 2:
//                  studentController.printListStudent(studentController.getListStudent());
                    ArrayList<Student> listStudent = getListStudentInfo();
                    System.out.println("\t\t============Danh sách sinh viên================");
                    studentController.printListStudent(listStudent);
                    break;
                case 3 :
                    System.out.println("Chỉnh sửa thông tin sinh viên");
                    break;
                case 4 :
                    System.out.println("Xóa sinh viên");
                    break;
                case 5:
                    System.out.println("Bye bye.");                    
                    break;
                default:
                    System.out.println("Lựa chọn sai vui lòng chọn lại.");
                    break;
            }
            if(choice == 3){
                break;
            }
        }
    }
}
