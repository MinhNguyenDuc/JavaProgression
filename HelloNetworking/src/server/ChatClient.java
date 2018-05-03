/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6000);
        System.out.println("Ket noi thanh cong vui long nhap tin nhan");
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            String line = scanner.nextLine();
            if("bye".equals(line)){
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        
        bw.close();
    }
}
