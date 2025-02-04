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

    public Maze(String filePath) { //initliaze maze using file
        load_info(filePath);
    }

    
    private void load_info(String filePath) { // Loads the maze from a file
        try {
            get_dimensions(filePath);  // Get dimensions first
            grid = new Cell[height][width];  // Initialize the grid with the correct size
            load_maze_to_array(filePath);    // load maze to grid
            get_start_end_indexs(filePath);  // Get start and end points
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void get_dimensions(String filePath) throws IOException { // Get the dimensions of the maze
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        
        while ((line = reader.readLine()) != null) {
            width = line.length(); //get the width
            height++;  // Increase the height for each line
        }

        reader.close();
    }

    // Load the maze from a file into the grid (creating Cell objects)
    public void load_maze_to_array(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int row = 0;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) { // If the line is empty, treat it as a path
                for (int col = 0; col < width; col++) {
                    grid[row][col] = new Cell(State.PASS);  // Set path for each column
                }
            } else {
                // Otherwise, process the normal maze line
                for (int col = 0; col < line.length(); col++) {
                    if (line.charAt(col) == '#') {
                        grid[row][col] = new Cell(State.WALL);  // Wall is '#'
                    } else {
                        grid[row][col] = new Cell(State.PASS);  // Path is ' '
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
            if (grid[row][0].getState() == State.PASS) { //search for PASS cell in first col
                startX = 0;
                startY = row;
            }
            if (grid[row][width - 1].getState() == State.PASS) { //seaerch for PASS cell in last col
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
    //get dimensions
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    //get end and start coords
    public void setEndY(int Endy){
        this.endY = Endy;
    }
    public void setEndX(int EndX){
        this.endY = EndX;
    }
    public void setStartY(int Starty){
        this.endY = Starty;
    }
    public void setStartX(int StartX){
        this.endY = StartX;
    }
    
    //get grid
    public Cell[][] getGrid(){
        return grid;
    }
}