package Game;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Controller {
    Board board;
    ArrayList<Integer> selection = new ArrayList<>();
    Integer[][] integerTroops = Board.initTroops();

    public Controller(int turn, Color[][] colors) {
        board = new Board(turn, colors, integerTroops);
        selection = board.getSelection();
    }

}
