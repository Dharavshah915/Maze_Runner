package ca.mcmaster.se2aa4.mazerunner;

public class Compass {

    protected final int[] dy = {-1, 0, 1, 0}; // x-direction change for going forward when facing: North, East, South, West
    protected final int[] dx = {0, 1, 0, -1}; // x-direction changes for going forward when facing: North, East, South, West
    protected int currentDirection; //current direction we are facing (0:North, 1:East, 2:South, 3:Right)
    public Compass(int startDirection){ //initialize with start direction
        this.currentDirection = startDirection;
    }
    public Compass(){ //overlaod constructor to allow comppass intialization without Startdirection pre determined

    }
}
