package Game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Risk extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();

        //construct countries in a continent (unreal mapping)
        //WHAT IF:
        //load an array into the gridpane? or key:val pairs? (coord:color)
        //builds each region w/associated color
        ArrayList boardColors = new ArrayList(20);  //3,3,4 x 2,3,3,2 countries
//        String[][] lineColorings = new String[][]{
//                {"blue", "blue", "blue", "red", "red", "red", "green", "green", "green", "green"},
//                {"blue", "blue", "blue", "red", "red", "red", "green", "green", "green", "green"},
//                {"blue", "blue", "green", "green", "red", "red", "green", "green", "black", "black"},
//                {"blue", "green", "green", "green", "blue", "blue", "blue", "green", "black", "black"},
//                {"red", "green", "green", "green", "blue", "blue", "blue", "black", "black", "black"},
//                {},
//        };
        Color[][] colors = new Color[][]{   //5x5 color grid BLACK SPACES ARE EMPTY-REGIONS
                {Color.GREEN, Color.GREEN, Color.GREEN, Color.BLUE, Color.BLUE},
                {Color.BLACK, Color.GREEN, Color.BLACK, Color.BLACK, Color.BLUE},
                {Color.BLACK, Color.GREEN, Color.BLUE, Color.BLACK, Color.BLUE},
                {Color.BLUE, Color.BLUE, Color.GREEN, Color.BLUE, Color.GREEN},
                {Color.BLACK, Color.BLUE, Color.BLACK, Color.BLACK, Color.GREEN},
        };

        for (int i=0; i<colors.length; i++) {
            for (int j=0; j<colors[i].length; j++) {
                Rectangle box = new Rectangle(50, 50, colors[j][i]);
                if (!colors[j][i].equals(Color.BLACK)) {
                    box.setStroke(Color.ORANGE);
                }
                else box.setStroke(Color.BLACK);
                gp.add(box, i, j);
            }
        }
        //logic to make border around each region


        Scene scene = new Scene(gp, 500, 500);
        stage.setTitle("Risk demo");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
