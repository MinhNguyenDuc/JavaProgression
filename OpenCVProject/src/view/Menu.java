/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class Menu {
    
    public static final String FILEPATH = "E:\\Project\\JavaAptech\\JavaApplication19\\sinhvien.txt";
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(FILEPATH);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(FILEPATH);
        BufferedWriter bw = new BufferedWriter(fw);
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }         
//        System.out.println("1. Them sinh vien");
//        Scanner scanner = new Scanner(System.in);
//        int choice = scanner.nextInt();
//        if(choice == 1){
//            System.out.println("Nhap ten sinh vien");
//            String name = scanner.nextLine();
//            fw.write(name);
//        }
        br.close();
//        bw.close();
    }
}
