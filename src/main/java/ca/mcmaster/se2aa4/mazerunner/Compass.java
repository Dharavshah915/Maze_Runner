package ca.mcmaster.se2aa4.mazerunner;

public class Compass {
    protected final int[] dy = {-1, 0, 1, 0}; // x-direction changes for Up, Right, Down, Left
    protected final int[] dx = {0, 1, 0, -1};
    protected int currentDirection;
    public Compass(int startDirection){
        this.currentDirection = startDirection;
    }
}
