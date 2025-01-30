package ca.mcmaster.se2aa4.mazerunner;

public class Cell {
    public enum State {
        PASS,   // Represents a passable cell (empty space)
        WALL    // Represents a wall cell
    }
    public State state;  // The state of the cell (either PASS or WALL)
    private int row;      // The row position of the cell
    private int col;      // The column position of the cell

    // Constructor to create a cell with a specific state and position
    public Cell(State state, int row, int col) {
        this.state = state;
        this.row = row;
        this.col = col;
    }

    // Get the state of the cell
    public State getState() {
        return state;
    }

    // Get the row position of the cell
    public int getRow() {
        return row;
    }

    // Get the column position of the cell
    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return state == State.PASS ? " " : "#";  // Display a space for PASS and a '#' for WALL
    }
}
