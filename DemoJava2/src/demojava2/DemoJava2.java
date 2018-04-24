/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojava2;

/**
 *
 * @author nguye
 */
public class DemoJava2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person p = new Person("Minh", 20, 1, "123");
//        p.setName("Minh");
//        p.setAge(20);
//        p.setGender(1);
//        p.setPhone("123456");
        System.out.println(p.toString());
    }

}
