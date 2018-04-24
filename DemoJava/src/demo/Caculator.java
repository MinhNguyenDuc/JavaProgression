/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *
 * @author nguye
 */
public class Caculator {

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    int a;
    int b;

    public Caculator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    int add(){
        return a + b;
    }
    
    int minus(){
        return a - b;
    }
    
    int mul(){
        return a*b;
    }
    
    float div(){
        if(b == 0){
            System.out.println("Fail");
            return -1;
        }
        else return (float)(a)/(float)(b);
    }
}
