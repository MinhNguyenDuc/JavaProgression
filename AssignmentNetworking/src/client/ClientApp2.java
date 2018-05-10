package client;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientApp2 extends Application {
    private Socket client;

    private int minX = 30;
    private int minY = 30;
    private int width = 50;
    private int height = 50;
    private final int step = 5;
    private final String imageUrl = "https://vignette.wikia.nocookie.net/fantendo/images/8/85/Flappy_Bird.png/revision/latest?cb=20140208141118";
    private GraphicsContext gc;
    private Image face;

    @Override
    public void start(Stage theStage) throws Exception {
        client = new Socket("localhost", 6000);
        System.out.println("Kết nối thành công đến máy chủ.");

        theStage.setTitle("Client 2");
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(700, 350);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();
        face = new Image(
                imageUrl,
                this.width, this.height, false, false);
        gc.drawImage(face, this.minX, this.minY);
        theStage.show();
        GameThread gt = new GameThread();
        gt.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class GameThread extends Thread {

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                while (true) {
                    String content = br.readLine();
                    System.out.println(content);
                    String[] points = content.split("\\|");
                    gc.clearRect(minX, minY, width, height);
                    minX = Integer.parseInt(points[0]);
                    minY = Integer.parseInt(points[1]);
                    gc.drawImage(face, minX, minY);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
