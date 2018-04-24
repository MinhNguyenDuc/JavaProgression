/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import controller.HanhDongTichCuc;

/**
 *
 * @author xuanhung
 */
public class ConNghien implements HanhDongTichCuc{

    @Override
    public void docsach() {
        System.out.println("Hướng dẫn lấy ven.");
    }

    @Override
    public void coding() {
        System.out.println("Quản lý lượng tiền ăn trộm.");
    }
    
}
