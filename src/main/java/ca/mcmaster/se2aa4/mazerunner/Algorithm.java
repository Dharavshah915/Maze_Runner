package ca.mcmaster.se2aa4.mazerunner;

public class Algorithm {
    protected Maze maze;
    protected int startX, startY, endX, endY;
    protected int currentX, currentY;
    protected int currentDirection;


    // Constructor to initialize the algorithm with the maze
    public Algorithm(Maze maze) {
        this.maze = maze;
        this.startX = maze.getStartX();
        this.startY = maze.getStartY();
        this.endX = maze.getEndX();
        this.endY = maze.getEndY();
        this.currentX = startX;
        this.currentY = startY;
        this.currentDirection = 1; // Default to starting direction (right)
    }

    // Abstract method to find the path (to be implemented by subclasses)
    public String findNextMove(){
      return("F");
    }

}
