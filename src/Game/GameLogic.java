package Game;

public class GameLogic {
    int turn = 0;
    private Object Board;

    public void gameInit() {    //get one array position
        //alternates between players to place troops in territories (gives each territory 2? troops)
        //needs to modify the <colors> and <troops> arrays
//        while ()
    }


    public void place() {   //get one array position
        //calculates how many troops a player should receive (based on % of board controlled)
        //needs the <colors> and <troops> arrays

    }


    public void move() {    //get two array positions
        //allows player to move troops between own territories (connected preferably, may add that logic later)

    }


    public void attack() {  //get two array positions
        //attack sequence, player selects own block first, then enemy block
        //uses roll() to determine who wins

    }


    public boolean roll() {
        //one is attacker, two  is defender
        double one = Math.random()*10%6;
        double two = Math.random()*10%6;
        return one > two;   //return true if attacker wins, false if attacker loses
    }


    private void selectTerritories() {  //returns the array positions of the user-selected blocks


    }
}
