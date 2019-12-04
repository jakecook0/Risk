package Game;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameLogic {
    Integer[][] integerTroops = Board.initTroops();
    Color[][] colors;

    public void gameInit(int turn, Color[][] colors) {    //get one array position
        //alternates between players to place troops in territories (gives each territory 2? troops)
        //needs to modify the <colors> and <troops> arrays
        boolean delimiter = true;

        while(delimiter){
            for(Color[] c: colors){
                for(Color c1: c){
                    if (c.equals(Color.WHITE)) {
                        delimiter = false;
                        break;
                    }
                }
            }
            ArrayList<Integer> click = getTerritories();
            if(turn == 0){
                colors[click.get(0)][click.get(1)] = (Color.BLUE);
                integerTroops[click.get(0)][click.get(1)] = 2;
            }else{
                colors[click.get(0)][click.get(1)] = (Color.RED);
                integerTroops[click.get(0)][click.get(1)] = 2;
            }
            turn = 1 - turn;
        }
    }


    public void place(int turn) {//get one array position
        //calculates how many troops a player should receive (based on % of board controlled)
        //needs the <colors> and <troops> arrays
        int countRed = 0;
        int countBlue = 0;
        for (Color[] c: colors) {
            for (Color c1 : c) {
                if(colors.equals(Color.RED)){
                    countRed++;
                }
                else if(colors.equals(Color.BLUE)){
                    countBlue++;
                }
            }
        }

        int troops = 0;
        if(turn == 0){
            troops = countBlue/68; //68 because that is how many possible squares there are.
        }else{
            troops = countRed/68;
        }
        troops *= Math.random()%6*10;
        ArrayList<Integer> territory = getTerritories();
        integerTroops[territory.get(0)][territory.get(1)] += troops;
    }


    public void move() {    //get two array positions
        //allows player to move troops between own territories (connected preferably, may add that logic later)
        ArrayList<Integer> territory = getTerritories();
        int row1 = territory.get(0);
        int col1 = territory.get(1);
        int row2 = territory.get(2);
        int col2 = territory.get(3);

        if (colors[row1][col1].equals(colors[row2][col2])){
            integerTroops[row2][col2] += (integerTroops[row1][col1] - 1);
        }
    }


    public void attack(int turn) {  //get two array positions
        //attack sequence, player selects own block first, then enemy block
        //uses roll() to determine who wins
        ArrayList<Integer> territory = getTerritories();
        int row1 = territory.get(0);
        int col1 = territory.get(1);
        int row2 = territory.get(2);
        int col2 = territory.get(3);

        if(colors[row1][col1].equals(colors[row2][col2])){
            return;
        }else{
            while(integerTroops[row1][col1] != 1 && integerTroops[row2][col2] != 0){
                boolean battleWinner = roll();
                if(battleWinner){
                    integerTroops[row2][col2]--;
                }else{
                    integerTroops[row1][col1]--;
                }
            }
            if(integerTroops[row2][col2] == 0) {
                integerTroops[row2][col2] += 1;
                integerTroops[row1][col1] -= 1;
                if(turn == 0){
                    colors[row2][col2] = Color.valueOf(String.valueOf(Color.BLUE));
                }else{
                    colors[row2][col2] = Color.valueOf(String.valueOf(Color.RED));
                }
            }else{
                return;
            }
        }
    }

    public int endTurn(int turn){
        turn = 1 - turn;
        return turn;
    }

    private boolean roll() {
        //one is attacker, two  is defender
        double one = Math.random()*10%6;
        double two = Math.random()*10%6;
        return one > two;   //return true if attacker wins, false if attacker loses
    }


    private ArrayList<Integer> getTerritories() {  //returns the array positions of the user-selected blocks
        return Board.getSelection();
    }
}

