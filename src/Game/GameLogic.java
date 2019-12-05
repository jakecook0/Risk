package Game;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameLogic {
//    Board board = new Board();
//    ArrayList<Integer> selections = board.selection;    //the selection doesn't save to this Instance of board, but a general one

    public GameLogic() {

    }

    public void gameInit(Board board) {    //get one array position
        //alternates between players to place troops in territories (gives each territory 2? troops)
        //needs to modify the colors[], troops[] and turn
        board.colors[board.selection.get(0)][board.selection.get(1)] = board.turn == 0 ? Color.BLUE : Color.RED;
        board.integerTroops[board.selection.get(0)][board.selection.get(1)] = 2;
        board.turn = 1 - board.turn;
        board.refresh(board);
    }


//    public static void place(int turn) {//get one array position
//        //calculates how many troops a player should receive (based on % of board controlled)
//        //needs the <colors> and <troops> arrays
//        int countRed = 0;
//        int countBlue = 0;
//        for (Color[] c: colors) {
//            for (Color c1 : c) {
//                if(c1.equals(Color.RED)){
//                    countRed++;
//                }
//                else if(c1.equals(Color.BLUE)){
//                    countBlue++;
//                }
//            }
//        }
//
//        int troops = 0;
//        if(turn == 0){
//            troops = countBlue/68; //68 because that is how many possible squares there are.
//        }
//        else{
//            troops = countRed/68;
//        }
//        troops *= Math.random()%6*10;
//        ArrayList<Integer> territory = getTerritories();
//        integerTroops[territory.get(0)][territory.get(1)] += troops;
//    }
//
//
//    public static void move() {    //get two array positions
//        //allows player to move troops between own territories (connected preferably, may add that logic later)
//        ArrayList<Integer> territory = getTerritories();
//        int row1 = territory.get(0);
//        int col1 = territory.get(1);
//        int row2 = territory.get(2);
//        int col2 = territory.get(3);
//
//        if (colors[row1][col1].equals(colors[row2][col2])){
//            integerTroops[row2][col2] += (integerTroops[row1][col1] - 1);
//        }
//    }
//
//
//    public void attack(int turn) {  //get two array positions
//        //attack sequence, player selects own block first, then enemy block
//        //uses roll() to determine who wins
//        ArrayList<Integer> territory = getTerritories();
//        int row1 = territory.get(0);
//        int col1 = territory.get(1);
//        int row2 = territory.get(2);
//        int col2 = territory.get(3);
//
//        if(colors[row1][col1].equals(colors[row2][col2])){
//            return;
//        }else{
//            while(integerTroops[row1][col1] != 1 && integerTroops[row2][col2] != 0){
//                boolean battleWinner = roll();
//                if(battleWinner){
//                    integerTroops[row2][col2]--;
//                }else{
//                    integerTroops[row1][col1]--;
//                }
//            }
//            if(integerTroops[row2][col2] == 0) {
//                integerTroops[row2][col2] += 1;
//                integerTroops[row1][col1] -= 1;
//                if(turn == 0){
//                    colors[row2][col2] = Color.valueOf(String.valueOf(Color.BLUE));
//                }else{
//                    colors[row2][col2] = Color.valueOf(String.valueOf(Color.RED));
//                }
//            }
//            else{
//                return;
//            }
//        }
//    }
//
//    public static int endTurn(int turn){
//        turn = 1 - turn;
//        return turn;
//    }
//
//    public boolean roll() {
//        //one is attacker, two  is defender
//        double one = Math.random()*10%6;
//        double two = Math.random()*10%6;
//        return one > two;   //return true if attacker wins, false if attacker loses
//    }
//
//
//    private ArrayList<Integer> getTerritories() {  //returns the array positions of the user-selected blocks
//        return Board.getSelection();
//    }
}