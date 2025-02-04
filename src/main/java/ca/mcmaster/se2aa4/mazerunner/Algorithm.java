package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public abstract class Algorithm extends Compass { //abstarct class 
    protected Maze maze;
    protected int currentX, currentY;
    protected int EndY, EndX;


    public Algorithm(Maze maze, int startDirection) { //initialized with maze and starting direction
        super(startDirection);
        this.maze = maze;
        
    }

    public abstract ArrayList<String> findPath(int startDirection);

}
