/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Account;
import java.util.Scanner;
import model.AccountModel;

/**
 *
 * @author nguye
 */
public class MainThread {
    public static void main(String[] args) {
        generateMenu();
    }
    public static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\nQuan ly ngan hang");
            System.out.println("==============================");
            System.out.println("1) Dang nhap");
            System.out.println("2) Dang ky");
            System.out.println("3) Thoat");
            System.out.println("Nhap lua chon cua ban:");
            String choice = scanner.nextLine();
            switch(choice) {
                case "1":
                    logIn();
                    break;
                case "2":
                    signUp();
                    break;
                case "3":
                    System.out.println("\nTam biet.");
                    break;
                default:
                    System.out.println("\nNhap sai. Vui long nhap lai.");
                    break;
            }
            if(choice.equals("3")){
                break;
            }    
        }
    }
    
    public static void logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nUsername: ");
        String username = scanner.nextLine();
        
        System.out.println("\nPassword: ");
        String password = scanner.nextLine();
        Account logInAccount = new Account(username,password);
        if(checkLogIn(logInAccount)){
            System.out.println("\nDang nhap thanh cong");
            logInAccount.setLoginStatus(true);
            logInOptions(logInAccount);
        }
        else {
            System.err.println("\nDang nhap that bai");
        }   
    }
    
    public static boolean checkLogIn(Account logInAccount) {
        AccountModel am = new AccountModel();
        return am.checklogIn(logInAccount);
    }
    
    public static void logInOptions(Account loggedInAccount){
        Scanner scanner = new Scanner(System.in);
        AccountModel am = new AccountModel();
        while(true){
            System.out.println("\nWelcome! "+loggedInAccount.getUsername());
            System.out.println("========================");
            System.out.println("1) Truy van so du");
            System.out.println("2) Rut tien");
            System.out.println("3) Gui tien");
            System.out.println("4) Dang xuat");
            System.out.println("5) Thoat");
            System.out.println("Nhap lua chon cua ban: ");
            String choice = scanner.nextLine();
            switch(choice) {
                case "1":
                    System.out.println("So du trong tai khoan la : ");
                    int balance = am.getBalanceInfo(loggedInAccount);
                    System.out.println(balance);
                    break;
                case "2":
                    withDraw(loggedInAccount);
                    break;
                case "3":
                    sendMoney(loggedInAccount);
                    break;
                case "4":
                    System.out.println("\nDang xuat thanh cong");
                    break;
                case "5":
                    System.out.println("\nTam biet");
                    break;
                default:
                    System.err.println("\nNhap sai. Vui long nhap lai.");
                    break;
            }
            if(choice.equals("4")){
                break;
            }
            if(choice.equals("5")){
               System.exit(0);
            }
        }
    }
    
    public static void withDraw(Account loggedInAcc){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap so tien ma ban muon rut : ");
        int amount = input.nextInt();
        AccountModel am = new AccountModel();
        if(!am.checkWithDrawAvailable(loggedInAcc, amount)){
            System.out.println("Rut tien that bai. So tien rut lon hon so du trong tai khoan");
        }
        else System.out.println("Rut tien thanh cong");
    }
    
    public static void sendMoney(Account a){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap so tien ma ban muon gui");
        int sendAmount = input.nextInt();
        AccountModel am = new AccountModel();
        am.sendMoney(a, sendAmount);
        System.out.println("Da gui tien thanh cong");
    }
    
    public static void signUp() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nUsername: ");
            String username = scanner.nextLine();

            System.out.println("\nPassword: ");
            String password = scanner.nextLine();

            System.out.println("\nConfirm Password: ");
            String passwordConfirm = scanner.nextLine();

            if(!passwordConfirm.equals(password)) {
                System.err.println("Password nhap lai khong dung.");
            }
            else {
                Account signUpAccount = new Account(username, password);
                checkSignUp(signUpAccount);
            }
    }
    
    public static void checkSignUp(Account signAccount){
        AccountModel am = new AccountModel();
        if(am.checkSignUp(signAccount)){
            System.out.println("\nDang ky thanh cong");
        }
        else {
            System.err.println("\nTen dang nhap da bi trung lap. Vui long dang ky lai");
        }
    }
}
