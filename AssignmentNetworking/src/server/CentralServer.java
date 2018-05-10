package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class CentralServer {

    public static ArrayList<ClientThread> listClient;

    public static void main(String[] args) {
        listClient = new ArrayList<>();
        int port = 6000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Start server on port " + port + " wait for clients...");
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected !!!");
                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
                listClient.add(clientThread);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadCasting(String content){
        System.out.println("BroadCasting...");
        System.out.println(listClient.size());
        try {
            for(ClientThread client : listClient){
                if(client.getSocket().isClosed()){
                    client.getBw().write(content);
                    client.getBw().newLine();
                    client.getBw().flush();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
