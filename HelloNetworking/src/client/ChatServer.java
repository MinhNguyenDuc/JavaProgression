/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nguye
 */
public class ChatServer {
    public static void main(String[] args) throws IOException {
        int port = 6000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Khoi dong server thanh cong. Doi client ket noi");
        while(true){
            Socket socket = serverSocket.accept();
            ClientThread ct = new ClientThread(socket);
            ct.start();
        }
        
        
        
    }
}
