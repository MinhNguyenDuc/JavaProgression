/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indeep;

import java.sql.SQLException;
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
import readingnews.entity.User;
import readingnews.model.UserModel;

/**
 *
 * @author xuanhung
 */
public class RegisterScene {

    private static RegisterScene instance;

    public static RegisterScene getInstance() {
        if (instance == null) {
            instance = new RegisterScene();
        }
        return instance;
    }

    private Scene scene;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public RegisterScene() {
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
        Label lblEmail = new Label("Email: ");
        TextField txtEmail = new TextField();
        Label lblPassword = new Label("Password: ");
        PasswordField txtPassword = new PasswordField();
        Button btnSubmit = new Button("Submit"); // component                         
        Button btnReset = new Button("Reset"); // component    
        Hyperlink linkLogin = new Hyperlink("Already have account? Login here.");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnSubmit, btnReset);
        hbox.setSpacing(10);

        root.add(lblUsername, 0, 0, 1, 1);
        root.add(lblEmail, 0, 1, 1, 1);
        root.add(lblPassword, 0, 2, 1, 1);
        root.add(txtUsername, 1, 0, 1, 1);
        root.add(txtEmail, 1, 1, 1, 1);
        root.add(txtPassword, 1, 2, 1, 1);
        root.add(hbox, 1, 3, 1, 1);
        root.add(linkLogin, 1, 4, 1, 1);

        linkLogin.setOnMouseClicked((MouseEvent event) -> {
            MyApplication.primaryStage.setScene(LoginScene.getInstance().getScene());
        });

        btnSubmit.setOnAction((ActionEvent event) -> {
            String username = txtUsername.getText();
            String email = txtEmail.getText();
            String password = txtPassword.getText();
            if (RegisterConfirm.showConfirm(
                    username,
                    email,
                    password)) {
                try {
                    new UserModel().register(new User(username, email, password));
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }                
            }
        });
        this.scene = new Scene(root, 500, 250);
    }

}
