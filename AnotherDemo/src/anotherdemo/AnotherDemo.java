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
public class AnotherDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Employee e1 = new Employee("Minh", "abc@1234");
        Employee e2 = new Employee("Minh2 ", "bcd@234");
        e1.setStatus(1);
        e2.setStatus(0);
        EmployeeController controller = new EmployeeController();
        controller.printEmployeeInfo(e1);
        controller.printEmployeeInfo(e2);
    }
    
}
