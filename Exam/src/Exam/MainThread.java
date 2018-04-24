/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class MainThread {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hotel[] listHotel = new Hotel[10];       
        Hotel h0 = new Hotel("hotelName1", "hotelLocation1", "hotelOwnerName1");
        Hotel h1 = new Hotel("hotelName2", "hotelLocation2", "hotelOwnerName2");
        Hotel h2 = new Hotel("hotelName3", "hotelLocation3", "hotelOwnerName3");
        Hotel h3 = new Hotel("hotelName4", "hotelLocation4", "hotelOwnerName4");
        Hotel h4 = new Hotel("hotelName5", "hotelLocation5", "hotelOwnerName5");
        Hotel h5 = new Hotel("hotelName6", "hotelLocation6", "hotelOwnerName6");
        Hotel h6 = new Hotel("hotelName7", "hotelLocation7", "hotelOwnerName7");
        Hotel h7 = new Hotel("hotelName8", "hotelLocation8", "hotelOwnerName8");
        Hotel h8 = new Hotel("hotelName9", "hotelLocation9", "hotelOwnerName9");
        Hotel h9 = new Hotel("hotelName10", "hotelLocation10", "hotelOwnerName10");
        listHotel[0] = h0;
        listHotel[1] = h1;
        listHotel[2] = h2;
        listHotel[3] = h3;
        listHotel[4] = h4;
        listHotel[5] = h5;
        listHotel[6] = h6;
        listHotel[7] = h7;
        listHotel[8] = h8;
        listHotel[9] = h9;
        System.out.println("Input an Owner's Name : ");
        String oName = input.nextLine();
        for(int i = 0; i < listHotel.length;i++){
            if(listHotel[i].getOwnerName().equals(oName)){
                System.out.println("Name of Hotel : "+listHotel[i].getName());
                System.out.println("Location : " + listHotel[i].getLocation());
            }
        }
    }
}
