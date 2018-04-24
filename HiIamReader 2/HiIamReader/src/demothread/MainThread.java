/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread;

/**
 *
 * @author xuanhung
 */
public class MainThread {

    public static void main(String[] args) {                
        Thread t1 = new Thread(new ThirdThread());
        Thread t2 = new Thread(new FourthThread());   
        t1.start();
        t2.start();

//        FirstThread f1 = new FirstThread();
//        SecondThread f2 = new SecondThread();
//        f1.start();
//        f2.start();
    }
}
