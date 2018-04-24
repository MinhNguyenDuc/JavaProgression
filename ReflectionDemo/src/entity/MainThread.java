/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.lang.reflect.Field;

/**
 *
 * @author nguye
 */
public class MainThread {

    public static void main(String[] args) {
        Student st1 = new Student(1, "Minh", "St1", 0);
        Customer ct1 = new Customer(1, "Hung", 100);
        MainThread mt = new MainThread();
//        mt.toString(st1);
        mt.toString(ct1);

    }

    public void toString(Object obj) {
        String className = obj.getClass().getName();
        System.out.println("=============================");
        System.out.println("Class Name : " + className);
        Field[] listFields = obj.getClass().getDeclaredFields();
        for (Field f : listFields) {
            try {
                f.setAccessible(true);
                System.out.println("Field Name : " + f.getName()
                        + ", type : " + f.getType().getSimpleName() + ", value: " + f.get(obj));
                //System.out.println("Field value: " + f.get(obj));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
