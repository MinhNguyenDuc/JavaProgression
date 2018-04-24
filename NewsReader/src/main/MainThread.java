/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class MainThread {

    public static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\tNews");
            System.out.println("1. Đọc tin trang chủ");
            System.out.println("2. Danh sách các danh mục");
            System.out.println("3. Đọc tin theo danh mục");
            System.out.println("4. Đọc tin chi tiết");
            System.out.println("5. Thoát chương trình");
            System.out.println("");
            System.out.println("Nhập lựa chọn của bạn : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Lấy danh sách tin trang chủ");
                    break;
                case 2:
                    System.out.println("Lấy danh sách danh mục");
                    break;
                case 3:
                    System.out.println("Lấy tin theo danh mục ");
                    break;
                case 4:
                    System.out.println("Lấy link chi tiết từ trang ");
                    break;
                case 5:
                    System.out.println("Bye");
                    break;
                default:
                    System.err.println("");
                    
            }
            if (choice == 5) {
                System.exit(0);
            }
        }

    }

    public static void main(String[] args) {
        generateMenu();
    }
}
