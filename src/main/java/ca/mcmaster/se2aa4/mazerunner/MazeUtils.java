package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Cell.State;

public class MazeUtils{
    
    public static boolean isValidMove(Maze maze , int x, int y) { // Check if a move is valid 
        if (x < 0 || x >= maze.getWidth() || y < 0 || y >= maze.getHeight()) {
            return false;  // Out of bounds
        }
        return maze.getGrid()[y][x].getState() == State.PASS;  // Wall is represented by '#'
    }

    public static void displayMaze(Maze maze) {  // Display the maze 
        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                System.out.println(maze.getGrid()[y][x]);
                
            }
            System.out.println();
        }
    }
    
    public static boolean isSolved(int EndX, int EndY, int x, int y) { //check if coords given match the end coords
        return x == EndX && y == EndY;
    }

}