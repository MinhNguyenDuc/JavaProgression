/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjavareflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 *
 * @author nguye
 */
public class TestJavaReflection {

    /**
     * @param args the command line arguments
     */
    
    public static void reflecttion(Object obj){
        String fullClassName = obj.getClass().toString();
        String[] className = fullClassName.split("[.]");
        System.out.println(className[className.length-1]);
        
    }
    
    
    public static void main(String[] args) {
        try {
            Class reflectClass = Class.forName("testjavareflection.SupClass");
            Method[] refMethods = reflectClass.getMethods();
            for(Method m : refMethods){
                System.out.println("Method : " + m.getName());
            }
            Method demoReflectMethod = reflectClass.getMethod("printSomething", String.class, String.class);
            demoReflectMethod.invoke(new SupClass("test", 0), "test1", "test 2");
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
        }     
        
    }
}
    

