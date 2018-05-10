package client;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;

public class ClientApp1 extends Application {
    private Socket client;

    private int minX = 30;
    private int minY = 30;
    private int width = 50;
    private int height = 50;
    private final int step = 5;
    private final String imageUrl = "https://vignette.wikia.nocookie.net/fantendo/images/8/85/Flappy_Bird.png/revision/latest?cb=20140208141118";

    @Override
    public void start(Stage primaryStage) throws Exception {
        int port = 6000;
        client = new Socket("localhost", port);
        System.out.println("Connected to server !!!");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), Charset.forName("UTF-8")));
        primaryStage.setTitle("Client 1");
        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas(700, 350);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image face = new Image(
                imageUrl,
                this.width, this.height, false, false);
        gc.drawImage(face, this.minX, this.minY);
        theScene.setOnKeyPressed((event) -> {
            if (null != event.getCode()) {
                switch (event.getCode()) {
                    case RIGHT:
                        gc.clearRect(this.minX, this.minY, this.width, this.height);
                        this.minX += this.step;
                        gc.drawImage(face, this.minX, this.minY);
                        break;
                    case LEFT:
                        gc.clearRect(this.minX, this.minY, this.width, this.height);
                        this.minX -= this.step;
                        gc.drawImage(face, this.minX, this.minY);
                        break;
                    case UP:
                        gc.clearRect(this.minX, this.minY, this.width, this.height);
                        this.minY -= this.step;
                        gc.drawImage(face, this.minX, this.minY);
                        break;
                    case DOWN:
                        gc.clearRect(this.minX, this.minY, this.width, this.height);
                        this.minY += this.step;
                        gc.drawImage(face, this.minX, this.minY);
                        break;
                    default:
                        break;
                }
                try {
                    bw.write(this.minX + "|" + this.minY);
                    bw.newLine();
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        primaryStage.show();
    }
}
