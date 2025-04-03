package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Cell.State;

public class MazeUtils{
    
    public static boolean isValidMove(Maze maze , Coordinate coord) { // Check if a move is valid 
        if (coord.getX() < 0 || coord.getX() >= maze.getWidth() || coord.getY() < 0 || coord.getY() >= maze.getHeight()) {
            return false;  // Out of bounds
        }
        return maze.getGrid()[coord.getY()][coord.getX()].getState() == State.PASS;  // Wall is represented by '#'
    }

    public static void displayMaze(Maze maze) {  // Display the maze 
        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                System.out.println(maze.getGrid()[y][x]);
                
            }
            System.out.println();
        }
    }
    
    public static boolean isSolved(Coordinate End, Coordinate Current) { //check if coords given match the end coords
        return End.equals(Current);
    }

}