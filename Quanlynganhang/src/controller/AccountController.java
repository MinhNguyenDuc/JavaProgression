/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import entity.Account;
/**
 *
 * @author nguye
 */
public class AccountController {
    public int getBalanceInfo(Account a){
        return a.getBalance();
    }
}
