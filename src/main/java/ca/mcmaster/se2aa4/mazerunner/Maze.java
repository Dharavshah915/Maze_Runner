package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ca.mcmaster.se2aa4.mazerunner.Cell.State;

public class Maze {

    private Cell[][] grid;  // 2D array to represent the maze
    private int width = 0;   // Maze width (number of columns)
    private int height = 0;  // Maze height (number of rows)
    private Coordinate start; // Starting coordinate
    private Coordinate end;   // Ending coordinate
    // private int startX;      // Starting point X-coordinate
    // private int startY;      // Starting point Y-coordinate
    // private int endX;        // Ending point X-coordinate
    // private int endY;        // Ending point Y-coordinate

  // private static Compass compass;
    //  //current direction we are facing (0:North, 1:East, 2:South, 3:Right)
    // private Compass(int startDirection){ //initialize with start direction
    //     this.currentDirection = startDirection;
    // }
    // public static Compass getInstance(int startDirection){ //get instance of compass
    //     if(compass == null){ //if compass is not initialized
    //         compass = new Compass(startDirection); //initialize compass
    //     }
    //     return compass; //return compass
    // }
    
    // public Compass(){ //overlaod constructor to allow comppass intialization without Startdirection pre determined

    // }
    private static Maze maze;

    private Maze(String filePath) { //initliaze maze using file
        load_info(filePath);
    }

    public static Maze getInstance(String filePath) { //get instance of maze
        if (maze == null) { //if maze is not initialized
            maze = new Maze(filePath); //initialize maze
        }
        return maze; //return maze
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
                int startX = 0;
                int startY = row;
                this.start = new Coordinate(startX, startY); //set start
            }
            if (grid[row][width - 1].getState() == State.PASS) { //seaerch for PASS cell in last col
                int endX = width - 1;
                int endY = row;
                this.end = new Coordinate(endX, endY); //set end
            }
        }
    }

    // Get the start position
    public int getStartX() {
        return start.getX();
    }

    public int getStartY() {
        return start.getY();
    }

    // Get the end position
    public int getEndX() {
        return end.getX();
    }

    public int getEndY() {
        return end.getY();
    }

    public Coordinate getStart() {
        return start;
    }
    public Coordinate getEnd() {
        return end;
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
        this.end.setY(Endy);
    }
    public void setEndX(int EndX){
        this.end.setX(EndX);
    }
    public void setStartY(int Starty){
        this.start.setY(Starty);
    }
    public void setStartX(int StartX){
        this.start.setX(StartX);
    }
    
    //get grid
    public Cell[][] getGrid(){
        return grid;
    }
}