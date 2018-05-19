/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indeep;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author xuanhung
 */
public class MyApplication extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MyApplication.primaryStage = primaryStage;
        MyApplication.primaryStage.setScene(RegisterScene.getInstance().getScene());
        MyApplication.primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
