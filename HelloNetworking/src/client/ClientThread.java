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
import java.net.Socket;

/**
 *
 * @author nguye
 */
public class ClientThread extends Thread {
    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;

    public ClientThread(Socket socket) {
        this.socket = socket;
        try {
            this.bw = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())); 
            this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } catch (Exception e) {
        }
        
    }

    @Override
    public void run() {
        while(true){
            try {
                String line = this.br.readLine();
                if("bye".equals(line)){
                    break;
                }
                System.out.println(this.socket.getInetAddress().getHostAddress() + " said : " + line);
            } catch (IOException e) {
                System.out.println(this.socket.getInetAddress().getHostAddress() + " da thoat ");
            }
        }
    }
    
}
