/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.DantriReader;
import controller.HanhDongTichCuc;
import controller.Reader;
import controller.VnexpressReader;
import entity.ConNghien;
import entity.ConNguoi;
import java.util.Scanner;

/**
 *
 * @author xuanhung
 */
public class MainThread {

    public static void main(String[] args) {
        generateMenu();
    }

    public static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a website to read: ");
        System.out.println("1. vnexpress.net");
        System.out.println("2. dantri.com.vn");
        System.out.println("Please enter you choice: ");
        int websiteChoice = scanner.nextInt();
        scanner.nextLine();

        Reader reader;
        if (websiteChoice == 1) {
            reader = new VnexpressReader();
        } else {
            reader = new DantriReader();
        }

        while (true) {
            // Hiển thị menu chương trình.        
            System.out.println("=================Article Reader==================");
            System.out.println("1. Get index articles.");
            System.out.println("2. Get list categories.");
            System.out.println("3. Get articles by category.");
            System.out.println("4. Get article detail.");
            System.out.println("7. Exit program.");
            System.out.println("==============================================");
            // Yêu cầu người dùng lựa chọn danh mục.
            System.out.println("Please enter your choice: ");
            // Gán giá trị lựa chọn của người dùng vào biến choice với kiểu 
            // dữ liệu là int. (Cần check kiểu dữ liệu chỗ này.)
            int choice = scanner.nextInt();
            // Ngay sau nextInt gọi nextLine để
            // có thể nhận dữ liệu từ nextLine trong lần gọi sau.
            scanner.nextLine();
            // Dựa vào lựa chọn người dùng, thực hiện các thao tác tiếp theo.                    
            switch (choice) {
                case 1:
                    reader.getIndexArticles();
                    break;
                case 2:
                    reader.getListCategories();
                    break;
                case 3:
//                    reader.getIndexArticles();
                    break;
                case 4:
//                    reader.getIndexArticles();
                    break;
                case 7:
                    System.out.println("Close program. See you again!");
                    break;
                default:
                    System.err.println("Wrong choice, please enter again: ");
                    break;
            }
            if (choice == 7) {
                break;
            }
        }

    }

    public static void readVnexpressNet() {

    }
}
