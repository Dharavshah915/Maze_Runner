package ca.mcmaster.se2aa4.mazerunner;

public class Player {
    private int x, y;    // Player's position
    private int direction; // 0 = Up, 1 = Right, 2 = Down, 3 = Left
    public String path = "";
    protected final int[] dx = {-1, 0, 1, 0}; // x-direction changes for Up, Right, Down, Left
    protected final int[] dy = {0, 1, 0, -1};
    public boolean doneMaze = false;


    private Maze maze;
    //Algorithm algorithm;

    public Player(Maze maze) { //Algorithm algorithm taken out for now
        this.maze = maze;
        this.x = maze.getStartX();
        this.y = maze.getStartY();
        this.direction = 1; // Starting direction (right)
        //this.algorithm = new Algorithm(maze);
    }

    public void followMove(String move) {
            switch (move) {
                case "F":
                    moveForward();
                    break;
                case "L":
                    turnLeft();
                    break;
                case "R":
                    turnRight();
                    break;
            }
    }

    private void moveForward() {
        x += dx[direction];
        y += dy[direction];
        path += "F";
    }

    private void turnLeft() {
        direction = (direction + 3) % 4; // Turn counter-clockwise
        path += "L";
    }

    private void turnRight() {
        direction = (direction + 1) % 4; // Turn clockwise
        path += "R";
    }

    public void isAtEnd() {
        doneMaze = true;
    }
}