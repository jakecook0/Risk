package Game;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Board extends BorderPane {

    GridPane gp = new GridPane();

    public Board(int turn){
        drawTitle(turn);
        drawBoard();
        drawButtons();
    }

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

    public void drawTitle(int turn){
        String who = turn == 0 ? "Blue" : "Red";
        Label lb = new Label(who + " player's turn");
        setTop(lb);
        lb.setFont(Font.font("SansSerif", 30));
        setAlignment(lb, Pos.CENTER);
    }

    public void drawButtons(){
        HBox pn = new HBox();
        Button place = new Button("Place");
        Button attack = new Button("Attack");
        Button move = new Button("Move");
        Button endTurn = new Button("End Turn");
        TextField("Troop #");
        pn.getChildren().addAll(place, attack, endTurn, move);
        setBottom(pn);
    }

    private void TextField(String s) {
    }

    public void drawBoard() {
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                //add a rectangle to the gridpane with associated color (init at white)
                if (!colors[j][i].equals(Color.BLACK)) {
                    Rectangle box = new Rectangle(50, 50, colors[j][i]);
                    box.setStroke(Color.ORANGE);
                    gp.add(box, i, j);
                    EventHandler<MouseEvent> clicked = e -> {
                        Rectangle r = (Rectangle) e.getSource();
                    };
                } else {
                    Rectangle box = new Rectangle(50, 50, colors[j][i]);
                    box.setStroke(Color.BLACK);
                    gp.add(box, i, j);
                }
            }
        }
        setCenter(gp);
    }
}
