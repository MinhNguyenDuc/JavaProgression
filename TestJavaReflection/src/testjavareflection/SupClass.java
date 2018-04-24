/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavareflection;

import java.lang.reflect.Method;

/**
 *
 * @author nguye
 */
public class SupClass {
    private String name;
    private int numb1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumb1() {
        return numb1;
    }

    public void setNumb1(int numb1) {
        this.numb1 = numb1;
    }

    public SupClass(String name, int numb1) {
        this.name = name;
        this.numb1 = numb1;
    }

    @Override
    public String toString() {
        return "SupClass{" + "name=" + name + ", numb1=" + numb1 + '}';
    }
    
    public void printSomething(String s1, String s2){
        System.out.println("Print Something : "+s1 +"  " + s2);
    }
    
    public static void main(String[] args) {
        Method[] listMethod = SupClass.class.getMethods();
        
        for(Method method : listMethod){
            System.out.println("Method " + method.getName());
        }
    }
    
}
