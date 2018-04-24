/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import BigModel.BigModel;
import entity.Customer;
import entity.Student;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class MainThread {
    public static void main(String[] args) {
        try {
            Student st1 = new Student("Nguyen Duc Minh", "Hanoi", "0123456", "ST1");
            Customer cs1 = new Customer("Minh1", "12345", "AC8", 0);
            BigModel<Student> bms = new BigModel<>(Student.class);
            BigModel<Customer> bmc = new BigModel<>(Customer.class);
            bmc.insert(cs1);  
            bms.insert(st1);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(MainThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
