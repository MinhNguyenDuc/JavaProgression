/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indeep;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author xuanhung
 */
public class LoginScene {
    
    private static LoginScene instance;

    public static LoginScene getInstance() {
        if (instance == null) {
            instance = new LoginScene();
        }
        return instance;
    }
    
    private Scene scene;

    public Scene getScene() {
        return scene;
    }

    public LoginScene() {
        initComponents();
    }

    private void initComponents() {
        GridPane root = new GridPane(); // layout
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);

        Label lblUsername = new Label("Username:");
        TextField txtUsername = new TextField();
        Label lblPassword = new Label("Password: ");
        PasswordField txtPassword = new PasswordField();
        Button btnLogin = new Button("Login"); // component                         
        Button btnReset = new Button("Reset"); // component      
        Hyperlink linkRegister = new Hyperlink("Have no account? Register here.");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnLogin, btnReset);
        hbox.setSpacing(10);

        root.add(lblUsername, 0, 0, 1, 1);
        root.add(lblPassword, 0, 1, 1, 1);
        root.add(txtUsername, 1, 0, 1, 1);
        root.add(txtPassword, 1, 1, 1, 1);
        root.add(hbox, 1, 3, 1, 1);
        root.add(linkRegister, 1, 4, 1, 1);

        linkRegister.setOnMouseClicked((MouseEvent event) -> {
            MyApplication.primaryStage.setScene(RegisterScene.getInstance().getScene());
        });

        btnLogin.setOnAction((ActionEvent event) -> {
            System.out.println("Beep beep. " + txtUsername.getText());
        });
        this.scene = new Scene(root, 400, 200);
    }
        
}
