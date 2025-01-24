package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {

    private char[][] grid;  // 2D array to represent the maze
    private int width;      // Maze width (number of columns)
    private int height;     // Maze height (number of rows)
    private int startX;     // Starting point X-coordinate
    private int startY;   // Starting point Y-coordinate
    private int endX;       // Ending point X-coordinate
    private int endY;     // Ending point Y-coordinate

    // Constructor: loads the maze from a file
    public Maze(String filePath) {
        load_info(filePath);
    }

    // Loads the maze from a file
    private void load_info(String filePath) {
        try {
            get_dimensions(filePath);
            grid = new char[height][width];
            load_maze_to_array(filePath);
            get_start_end_indexs(filePath);

        } catch (Exception e) {
            System.out.println(e);
        }
        

    }

    public void get_dimensions(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        // First pass to get height and width
        while ((line = reader.readLine()) != null) {
            width = Math.max(width, line.length()); // Update width
            height++;
        }
        reader.close(); // Close the reader after getting the height and width
    }

    public void load_maze_to_array(String filePath) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int row = 0;
        while ((line = reader.readLine()) != null) {
            for (int col = 0; col < line.length(); col++) {
                grid[row][col] = line.charAt(col);
            }
            row++;
        }
        reader.close();
    }

    public void get_start_end_indexs(String filePath){
        for (int row = 0; row < height; row++){
            if (grid[row][0] != '#'){
                startX = 0;
                startY = row;
            }
            if (grid[row][width-1] != '#'){
                endX = width -1;
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

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    // Get the content of a specific cell in the maze
    public char getCell(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return grid[y][x];
        }
        return '\0'; // Return null character for invalid coordinates
    }

    // Check if a move is valid (i.e., within the maze boundaries and not a wall)
    public boolean isValidMove(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return false;  // Out of bounds
        }
        return grid[y][x] != '#';  // Wall is represented by '#'
    }

    // Display the maze (for debugging purposes)
    public void displayMaze() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
    }

    // Method to check if the maze is solved (if the player reaches the end)
    public boolean isSolved(int x, int y) {
        return x == endX && y == endY;
    }
}