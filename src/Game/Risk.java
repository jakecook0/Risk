package Game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Risk extends Application {
    int turn = 0;   //turn global

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        Board board = new Board(turn);
        //construct countries in a continent (unreal mapping)
        //load an array into the gridpane
        //builds each region w/associated color

        bp.getChildren().addAll(board);
        Scene scene = new Scene(bp, 750, 750);
        stage.setTitle("Risk demo");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
