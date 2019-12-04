package Game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Risk extends Application {
    int turn = 0;   //turn global
    Color[][] colors = new Color[][]{   //10x10 color grid BLACK SPACES ARE EMPTY-REGIONS
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK},
            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK},
            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK},
            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE,},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE,},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK},
    };

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
//        Board board = new Board(turn, colors, Board.initTroops());
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
