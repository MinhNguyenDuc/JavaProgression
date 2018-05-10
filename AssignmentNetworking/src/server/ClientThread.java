package server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

public class ClientThread extends Thread {
    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public BufferedReader getBr() {
        return br;
    }
    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    public ClientThread(Socket socket){
        this.socket = socket;
        try {
            this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), Charset.forName("UTF-8")));
            this.bw = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream(), Charset.forName("UTF-8")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                String line = this.br.readLine();
                if(null != line) {
                    System.out.println("Client " + this.socket.getInetAddress().getHostAddress() + " send " + line);
                    CentralServer.broadCasting(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
