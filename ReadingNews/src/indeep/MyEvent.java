/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indeep;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 *
 * @author minhnguyenduc
 */
public class MyEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Beep");
    }
    
}
