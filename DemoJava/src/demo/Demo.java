/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b;
        System.out.print("Enter 2 number : ");
        a = scanner.nextInt();
        b = scanner.nextInt();
        Caculator caculator = new Caculator(a, b);
        System.out.println("Tong : " + caculator.add());
        System.out.println("Hieu : " + caculator.minus());
        System.out.println("Tich : " + caculator.mul());
        
    }
}
