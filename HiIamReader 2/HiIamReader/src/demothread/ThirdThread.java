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
public class ThirdThread implements Runnable {

    int coin = 0;
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            coin++;
            System.out.println("Coin (3) = " + coin);
        }
    }

}
