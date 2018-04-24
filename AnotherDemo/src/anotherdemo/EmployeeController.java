/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anotherdemo;

/**
 *
 * @author nguye
 */
public class EmployeeController {
    void printEmployeeInfo(Employee e){
        System.out.println("Employee{" + "id=" + e.getId() + ", name=" + e.getName() + ", email=" + e.getEmail() + ", phone=" + e.getPhone() + ", birthDay=" + e.getBirthDay() + ", address=" + e.getAddress() + ", workingHours=" + e.getWorkingHours() + ", salaryPerHour=" + e.getSalaryPerHour() + ", joinDate=" + e.getJoinDate() + ", status=" + e.getStatus() + '}');
        if(e.getStatus() != 0){
            System.out.println("Total salary : " +e.getSalaryPerHour()*e.getWorkingHours());
        } else {
            System.out.println("Nhan vien da nghi viec");
            return;
        }
    }
}
