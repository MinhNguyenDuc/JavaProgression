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
public class FirstThread extends Thread {
    
    int coin = 10;
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            coin++;
            System.out.println("First Thread - coin = " + coin);
        }
    }
}
