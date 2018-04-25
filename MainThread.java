/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Adminis
 */
public class MainThread {

    public static void main(String[] args) throws IOException {
        generateMenu();

    }

    public static void generateMenu() throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Quản lý sinh viên");
            System.out.println("========================");
            System.out.println("1. Hiển thị danh sách.");
            System.out.println("2. Thêm mới.");
            System.out.println("3. Thoát.");
            System.out.println("Vui lòng nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    try {
                        FileReader fileReader = new FileReader("sinhvien.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = null;
                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println(line);
                        }
                        bufferedReader.close();
                    } catch (Exception e) {
                        System.out.println("Không có dữ liệu hoặc không mở được file.");
                    }
                    break;
                case 2:
                    try {
                        FileWriter fileWriter = new FileWriter("sinhvien.txt", true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        System.out.println("Nhập tên sinh viên");
                        String name = scanner.nextLine();
                        bufferedWriter.write(name);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Bye bye.");
                    break;
                default:
                    System.out.println("Lựa chọn sai vui lòng chọn lại.");
                    break;
            }
            if (choice == 3) {
                break;
            }
        }
    }

}
