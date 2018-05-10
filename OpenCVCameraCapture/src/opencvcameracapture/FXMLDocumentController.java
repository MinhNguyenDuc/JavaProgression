/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencvcameracapture;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author nguye
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private BorderPane start_btn;
    @FXML
    private ImageView currentFrame;
    
    private VideoCapture capture = new VideoCapture();
    private boolean cameraActive = false;
    private int cameraId = 0;
    
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void startCamera(ActionEvent event) {
        if(!this.cameraActive){
            //start the camera
            this.capture.open(cameraId);
            
            //is the video stream available
            if(this.capture.isOpened()){
                this.cameraActive = true;
                
                //Grab a frame for every 33ms
                
            }
        }
    }
    
}
