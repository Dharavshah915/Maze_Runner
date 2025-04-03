package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public abstract class Algorithm { //abstarct class 
    protected Maze maze;
    protected Coordinate CurrentCoord; // Assuming Coordinate is a class with a getX() method
    protected Coordinate EndCoord;
    protected Compass compass;


    public Algorithm(Maze maze, Compass compass) { //initialized with maze and starting direction
        this.maze = maze;
        this.compass = compass;//pre set direction
        
    }

    private void setEndCoord(Coordinate endCoord) { //set end coordinates
        this.EndCoord = endCoord;
    }
    private void setCurrentCoord(Coordinate currentCoord) { //set current coordinates
        this.CurrentCoord = currentCoord;
    }
    public Coordinate getEndCoord() { //get end coordinates
        return EndCoord;
    }
    public Coordinate getCurrentCoord() { //get current coordinates
        return CurrentCoord;
    }
    public int getCurrentX() { //get current x coordinates
        return CurrentCoord.getX();
    }

    public int getCurrentY() { //get current y coordinates
        return CurrentCoord.getY();
    }
    public int getEndX() { //get end x coordinates
        return maze.getEndX();
    }
    public int getEndY() { //get end y coordinates
        return maze.getEndY();
    }

    public abstract ArrayList<String> findPath(int startDirection);

}
