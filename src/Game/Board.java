package Game;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;

public class Board extends GameLogic {
    BorderPane bp = new BorderPane();
    GridPane gpColors = new GridPane();
    GridPane gpTroops = new GridPane();
    GridPane gpSelection = new GridPane();
    Rectangle[][] boardColors = new Rectangle[10][10];
    Rectangle[][] boardSelections = new Rectangle[10][10];
    Label[][] boardTroops = new Label[10][10];
    StackPane sp = new StackPane();
    Integer[][] integerTroops = new Integer[10][10];
    static ArrayList<Integer> selection = new ArrayList<>();
    int turn = 0;
    static Color[][] colors = new Color[][]{   //10x10 color grid BLACK SPACES ARE EMPTY-REGIONS
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
    Button place = new Button("Place");
    Button attack = new Button("Attack");
    Button move = new Button("Move");
    Button endTurn = new Button("End Turn");
    Button clearSelections = new Button("Clear Selections");
    Button newGame = new Button("New Game");
    TextField input = new TextField("Troop #");

    public Board(){
        initTroops();   //initializes the board troops to '0'
        initSelections();
        setActions();   //sets the actions of the buttons (from the GameLogic)
        refresh();  //draws the GUI
    }

    public void refresh() {
        drawTitle();
        drawBoard();
        drawButtons();
    }

    public void drawTitle(){
        String who = turn == 0 ? "Blue" : "Red";
        Label lb = new Label(who + " player's turn");
        lb.setFont(Font.font("SansSerif", 30));
        bp.setTop(lb);
        bp.setAlignment(lb, Pos.CENTER);
    }

    public void drawButtons(){
        System.out.println("I reached this");
        HBox pn = new HBox();
        pn.getChildren().addAll(place, attack, move, endTurn, clearSelections, newGame);
        pn.setAlignment(Pos.CENTER);
        bp.setBottom(pn);
    }

    private void TextField(String s) {
    }

    public void drawBoard() {
        clearPanes();
        convertColors(colors);
        convertTroops();
//        convertSelections();

        for (int i = 0; i < boardColors.length; i++) {
            for (int j = 0; j < boardColors[i].length; j++) {
//                StackPane tmpStack = new StackPane();
//                tmpStack.getChildren().addAll(boardColors[i][j], boardTroops[i][j], boardSelections[i][j]);
//                gpColors.add(tmpStack, j, i);
                gpColors.add(boardColors[i][j], j, i);
                gpTroops.add(boardTroops[i][j], j, i);
                gpSelection.add(boardSelections[i][j], j, i);
            }
        }

        gpTroops.setAlignment(Pos.CENTER);
        gpColors.setAlignment(Pos.CENTER);
        gpSelection.setAlignment(Pos.CENTER);
        gpTroops.setVgap(36);
        gpTroops.setHgap(41);
        sp.setAlignment(Pos.CENTER);
        sp.getChildren().addAll(gpColors, gpTroops, gpSelection);
        bp.setCenter(sp);
    }

    private EventHandler<MouseEvent> clickedBox = e -> {
        Rectangle r = (Rectangle)e.getSource();
        int row = gpColors.getRowIndex(r);
        int col = gpColors.getColumnIndex(r);
        //give clicked result to something
        System.out.println("This box was clicked: " + row + ", " + col + "\nWith color Value: " + boardColors[row][col]);    //for testing purposes
        highlightSelection(row, col);
        selection.add(row);
        selection.add(col);
    };

    private void convertColors(Color[][] colors) {      //makes regions clickable
        for (int i=0; i < colors.length; i++) {
            for (int j=0; j < colors[i].length; j++) {
                Rectangle r = new Rectangle(50, 50);
                r.setFill(colors[i][j]);
                if (colors[i][j] != Color.BLACK) r.setStroke(Color.ORANGE);
                else r.setStroke(Color.BLACK);
                boardColors[i][j] = r;
            }
        }
    }

    private void convertTroops() {     //makes Integers Node objects to put in gpTroops to stack on gpColors
        for (int i=0; i<integerTroops.length; i++) {
            for (int j=0; j<integerTroops[i].length; j++) {
                boardTroops[i][j] = new Label(Integer.toString(integerTroops[i][j]));
            }
        }
    }

    private void highlightSelection(int i, int j) {
        boardSelections[i][j].setStroke(Color.GREEN);
        boardSelections[i][j].setFill(Color.GREY);
        boardSelections[i][j].setOpacity(0.2);
    }

    public void clearSelection() {
        System.out.println(selection);
        for (int i=0; i<boardSelections.length; i++) {
            for (int j=0; j<boardSelections[i].length; j++) {
                boardSelections[i][j].setStroke(Color.TRANSPARENT);
                boardSelections[i][j].setFill(Color.TRANSPARENT);
            }
        }
        selection = new ArrayList<>();
    }

    private void clearPanes() {
        bp = new BorderPane();
        gpColors = new GridPane();
        gpTroops = new GridPane();
        gpSelection = new GridPane();
    }

    //getter and setters

    public static ArrayList<Integer> getSelection() {
        return selection;
    }
    public static Color[][] getColors() {
        return colors;
    }

    public void initTroops() {
        for (Integer[] troop : integerTroops) {
            Arrays.fill(troop, 0);
        }
    }   //integer troops initializer to 0;

    public void setActions() {
        place.setOnAction(e -> place(turn));
        attack.setOnAction(e -> attack(turn));
        move.setOnAction(e -> move());
        endTurn.setOnAction(e -> endTurn(turn));
        clearSelections.setOnAction(e -> clearSelection());
        newGame.setOnAction(e -> gameInit(turn));
    }

    public void initSelections() {
        for(int i=0; i<boardSelections.length; i++) {
            for(int j=0; j< boardSelections[i].length; j++) {
                boardSelections[i][j] = new Rectangle(50,50);
                boardSelections[i][j].setStroke(Color.TRANSPARENT);
                boardSelections[i][j].setFill(Color.TRANSPARENT);
                if (colors[i][j] != Color.BLACK) boardSelections[i][j].setOnMouseClicked(clickedBox);
            }
        }
    }
}
