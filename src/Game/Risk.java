package Game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;


public class Risk extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        int turn = 0;   //turn global
        GridPane gp = new GridPane();

        //construct countries in a continent (unreal mapping)
        //load an array into the gridpane
        //builds each region w/associated color

        Color[][] colors = new Color[][]{   //5x5 color grid BLACK SPACES ARE EMPTY-REGIONS
                {Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK},
                {Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK},
                {Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK},
                {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE},
                {Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE,},
                {Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE,},
                {Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK},
                {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK},
        };

        for (int i=0; i<colors.length; i++) {
            for (int j=0; j<colors[i].length; j++) {
                //add a rectangle to the gridpane with associated color (init at white)
                if (!colors[j][i].equals(Color.BLACK)) {
                    Rectangle box = new Rectangle(75, 75, colors[j][i]);
                    box.setStroke(Color.ORANGE);
                    gp.add(box, i, j);
                    EventHandler<MouseEvent> clicked = e -> {
                        Rectangle r = (Rectangle)e.getSource();
                    };
                }
                else {
                    Rectangle box = new Rectangle(75,75, colors[j][i]);
                    box.setStroke(Color.BLACK);
                    gp.add(box, i, j);
                }

            }
        }
        //logic to make border around each region


        Scene scene = new Scene(gp, 750, 750);
        stage.setTitle("Risk demo");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
