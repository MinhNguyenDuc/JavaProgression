/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingnews;

import java.io.IOException;
import java.net.URL;
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
import model.UserModel;
import readingnews.entity.User;

/**
 * FXML Controller class
 *
 * @author minhnguyen
 */
public class RegisterFormController implements Initializable {

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField email;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button signUpBtn;
    @FXML
    private Label backToLoginLabel;
    @FXML
    private Pane content_area;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void register(ActionEvent event) {
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        String confirmPassword = this.confirmPasswordField.getText();
        String email    = this.email.getText();
        
        if(password.equals(confirmPassword)){
            System.out.println(username + " " + password + " " + email);
            User user = new User(username, password, email, System.currentTimeMillis());
            UserModel model = new UserModel();
            model.register(user);
        }
    }

    @FXML
    private void backToLogin(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginForm.fxml"));
        Parent root = loader.load();
        Pane foo = (Pane)loader.getNamespace().get("content_area");
        content_area.getChildren().removeAll();
        content_area.getChildren().setAll(foo);
    }
    
}
