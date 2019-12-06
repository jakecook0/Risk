package Game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Risk extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Board board = new Board();

        Scene scene = new Scene(board.bp, 750, 750);
        stage.setTitle("Risk demo");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
