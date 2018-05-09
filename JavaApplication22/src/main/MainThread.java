/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class MainThread {
    
    public static ArrayList<Book> listBook = new ArrayList<>();
    
    public static void main(String[] args) {
        generateMenu();
    }
    
    public static void generateMenu(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1. Add books records");
            System.out.println("2. Save");
            System.out.println("3. Display book records");
            System.out.println("4. Exit");
            System.out.println("Enter option : ");
            choice = scanner.nextInt();
            switch(choice){ 
                case 1: add(); break;
                case 2: 
                    try {
                        save();
                    } catch (Exception e) {
                    }
                    break;
                case 3: 
                    try {
                        display();
                    } catch (Exception e) {
                    }
                    break;
                case 4: System.exit(0); 
            }
        }
    }
    
    
    public static void add(){
        String id;
        String name;
        String author;
        int price;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book detail : ");
        System.out.println("Book ID : ");
        id = scanner.nextLine();
        System.out.println("Book Title : ");
        name = scanner.nextLine();
        System.out.println("Author : ");
        author = scanner.nextLine();
        System.out.println("Price : ");
        price = scanner.nextInt();
        Book book = new Book(id, name, author, price);
        listBook.add(book);
    }
    
    public static void save() throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream("E:\\Project\\JavaAptech\\JavaApplication22\\books.dat");
        OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("utf-8"));
        BufferedWriter bufferWriter = new BufferedWriter(osw);
        bufferWriter.write("Book ID \t|\t Book Name \t|\t Author \t|\t Price");
        bufferWriter.newLine();
        for(Book b : listBook){
            bufferWriter.write(String.format("%10s", b.getId()));
            bufferWriter.write("\t|\t");
            bufferWriter.write(String.format("%10s", b.getName()));
            bufferWriter.write("\t|\t");            
            bufferWriter.write(String.format("%10s", b.getAuthor()));
            bufferWriter.write("\t|\t");
            bufferWriter.write(String.format("%4s", String.valueOf(b.getPrice())));        
            bufferWriter.newLine();
        }
        bufferWriter.close();
        osw.close();
        fos.close();
    }
    
    public static void display() throws FileNotFoundException, IOException{
        FileReader file = new FileReader("E:\\Project\\JavaAptech\\JavaApplication22\\books.dat");
        BufferedReader br = new BufferedReader(file);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
        file.close();
    }
}
