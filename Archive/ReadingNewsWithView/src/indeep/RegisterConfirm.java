/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indeep;

import java.awt.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author xuanhung
 */
public class RegisterConfirm {

    private static boolean userChoice = false;

    public static boolean showConfirm(String username, String email, String password) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Confirm box");
        
        GridPane root = new GridPane(); // layout
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);

        Label lblConfirm = new Label("Do you want to create an account with below information?");
        lblConfirm.setWrapText(true);
        Label lblUsername = new Label("Username: " + username);
        Label lblEmail = new Label("Email: " + email);
        Label lblPassword = new Label("Password: *****" + password.substring(5, password.length()));
        Button btnYes = new Button("Yes"); // component                         
        Button btnNo = new Button("No"); // component   

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnYes, btnNo);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(0, 0, 0, 15));

        root.add(lblConfirm, 0, 0, 1, 2);
        root.add(lblUsername, 0, 2, 1, 1);
        root.add(lblEmail, 0, 3, 1, 1);
        root.add(lblPassword, 0, 4, 1, 1);
        root.add(hbox, 0, 5, 1, 1);

        btnYes.setOnAction((ActionEvent event) -> {
            userChoice = true;
            stage.close();
        });
        btnNo.setOnAction((ActionEvent event) -> {
            userChoice = false;
            stage.close();
        });

        Scene scene = new Scene(root, 300, 200);       
        stage.setScene(scene);
        stage.showAndWait();
        return userChoice;
    }
}
