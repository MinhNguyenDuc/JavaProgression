/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indeep;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author minhnguyenduc
 */
public class LoginForm extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root1 = new GridPane();
        root1.setVgap(10);
        root1.setHgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.CENTER);
        
        Label lblUsername = new Label("Username: ");
        TextField txtUsername = new TextField();
        Label lblEmail = new Label("Email: ");
        TextField txtEmail = new TextField();
        Label lblPassword = new Label("Password: ");
        PasswordField txtPassword = new PasswordField();
        Button btnSubmit = new Button("Submit");
        Button btnReset = new Button("Reset");
        
        root1.add(lblUsername, 0, 0, 1, 1);
        root1.add(lblEmail, 0, 1, 1, 1);
        root1.add(lblPassword, 0, 2, 1, 1);
        root1.add(txtUsername, 1, 0, 1, 1);
        root1.add(txtEmail, 1, 1, 1, 1);
        root1.add(txtPassword, 1, 2, 1, 1);
        
        
        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(btnSubmit, btnReset);
        hbox1.setSpacing(10);
        root1.add(hbox1, 1, 3, 1, 1);

        
        
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Beep Beep." + txtUsername.getText());
            }
        });
        
        
                
        Scene scene = new Scene(root1, 500, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
