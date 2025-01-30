package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Cell.State;

public class MazeUtils{
    public static State getCellState(Maze maze ,int x, int y) {
        if (x >= 0 && x < maze.getWidth() && y >= 0 && y < maze.getHeight()) {
            return maze.getGrid()[y][x].getState();
        }
        return null;
    }

    // Check if a move is valid (i.e., within the maze boundaries and not a wall)
    public static boolean isValidMove(Maze maze , int x, int y) {
        if (x < 0 || x >= maze.getWidth() || y < 0 || y >= maze.getHeight()) {
            return false;  // Out of bounds
        }
        return maze.getGrid()[y][x].getState() == State.PASS;  // Wall is represented by '#'
    }

    // Display the maze (for debugging purposes)
    public static void displayMaze(Maze maze) {
        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                System.out.print(maze.getGrid()[y][x].getState() == State.WALL ? "#" : " ");
                
            }
            System.out.println();
        }
    }
    public static boolean isSolved(Maze maze, int x, int y) {
        return x == maze.getEndX() && y == maze.getEndY();
    }

    

}