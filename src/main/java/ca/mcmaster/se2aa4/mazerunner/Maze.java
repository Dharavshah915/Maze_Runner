package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ca.mcmaster.se2aa4.mazerunner.Cell.State;

public class Maze {

    private Cell[][] grid;  // 2D array to represent the maze
    private int width = 0;   // Maze width (number of columns)
    private int height = 0;  // Maze height (number of rows)
    private int startX;      // Starting point X-coordinate
    private int startY;      // Starting point Y-coordinate
    private int endX;        // Ending point X-coordinate
    private int endY;        // Ending point Y-coordinate

    // Constructor: loads the maze from a file
    public Maze(String filePath) {
        load_info(filePath);
    }

    // Loads the maze from a file
    private void load_info(String filePath) {
        try {
            get_dimensions(filePath);  // Get dimensions first
            grid = new Cell[height][width];  // Initialize the grid with the correct size
            load_maze_to_array(filePath);    // Then, load the maze into the grid
            get_start_end_indexs(filePath);  // Get start and end points
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Get the dimensions of the maze (width and height)
    public void get_dimensions(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        // First pass to get height and width
        while ((line = reader.readLine()) != null) {
            width = Math.max(width, line.length());  // Update width
            height++;  // Increase the height for each line
        }
        reader.close();  // Close the reader after getting the height and width
    }

    // Load the maze from a file into the grid (creating Cell objects)
    public void load_maze_to_array(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int row = 0;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) { // If the line is empty, treat it as a path
                for (int col = 0; col < width; col++) {
                    grid[row][col] = new Cell(State.PASS, row, col);  // Set path for each column
                }
            } else {
                // Otherwise, process the normal maze line
                for (int col = 0; col < line.length(); col++) {
                    if (line.charAt(col) == '#') {
                        grid[row][col] = new Cell(State.WALL, row, col);  // Wall is '#'
                    } else {
                        grid[row][col] = new Cell(State.PASS, row, col);  // Path is ' '
                    }
                }
            }
            row++;
        }
        reader.close();  // Close the reader after loading the maze  
    }
    

    // Get the start and end positions from the grid
    public void get_start_end_indexs(String filePath) {
        for (int row = 0; row < height; row++) {
            if (grid[row][0].getState() == State.PASS) {
                startX = 0;
                startY = row;
            }
            if (grid[row][width - 1].getState() == State.PASS) {
                endX = width - 1;
                endY = row;
            }
        }
    }

    // Get the start position
    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    // Get the end position
    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell[][] getGrid(){
        return grid;
    }

    // Get the state of a specific cell
    // public State getCellState(int x, int y) {
    //     if (x >= 0 && x < width && y >= 0 && y < height) {
    //         return grid[y][x].getState();
    //     }
    //     return null;
    // }

    // // Check if a move is valid (i.e., within the maze boundaries and not a wall)
    // public boolean isValidMove(int x, int y) {
    //     if (x < 0 || x >= width || y < 0 || y >= height) {
    //         return false;  // Out of bounds
    //     }
    //     return grid[y][x].getState() == State.PASS;  // Wall is represented by '#'
    // }

    // // Display the maze (for debugging purposes)
    // public void displayMaze() {
    //     for (int y = 0; y < height; y++) {
    //         for (int x = 0; x < width; x++) {
    //             if (grid[y][x] == null) {
    //                 System.out.print("null");
    //             } else {
    //                 System.out.print(grid[y][x].getState() == State.WALL ? "#" : " ");
    //             }
    //         }
    //         System.out.println();
    //     }
    // }

    // // Method to check if the maze is solved (if the player reaches the end)
    // public boolean isSolved(int x, int y) {
    //     return x == endX && y == endY;
    // }
}
