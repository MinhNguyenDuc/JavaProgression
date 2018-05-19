/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingnewswithview;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import readingnews.entity.User;
import readingnews.model.UserModel;

/**
 *
 * @author xuanhung
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label labelLogo;
    @FXML
    private Button btnSubmit;
    @FXML
    private Pane formContent;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnReset;
    
    private UserModel userModel = new UserModel();
    @FXML
    private Label lblLogin;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void handleClick(ActionEvent event) {
        labelLogo.setText("Biệt đội java");
    }

    @FXML
    private void doSubmit(ActionEvent event) throws SQLException {
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        userModel.register(new User(username, email, password));
    }

    @FXML
    private void openLogin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        formContent.getChildren().clear();
        formContent.getChildren().addAll(root);
    }
    
}
