package ca.mcmaster.se2aa4.mazerunner;

public class Cell {
    
    public State state;    //state of cell represneted by enum
     

    public Cell(State state) {
        this.state = state;
    }

    public enum State {
        PASS,   //Represents a place that can be walked on
        WALL    //Represents a wall
    }
    
    public State getState() { //Get the state of cell
        return state; 
    }

    @Override // overriding print
    public String toString() {
        if (state ==  State.PASS){
            return " ";
        }
        return "#";
    }
}
