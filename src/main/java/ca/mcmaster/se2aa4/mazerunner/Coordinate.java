package ca.mcmaster.se2aa4.mazerunner;

public class Coordinate {

    protected final int[] dy = {-1, 0, 1, 0}; // x-direction change for going forward when facing: North, East, South, West
    protected final int[] dx = {0, 1, 0, -1}; //y-direction change for going forward when facing: North, East, South, West
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { //get x coordinate
        return x;
    }

    public int getY() { //get y coordinate
        return y;
    }

    public void setX(int x) { //set x coordinate
        this.x = x;
    }
    public void setY(int y) { //set y coordinate
        this.y = y;
    }
    public void setCoordinate(int x, int y) { //set coordinates
        this.x = x;
        this.y = y;
    }

    public void move(int direction){ //move in direction
        this.x = x + dx[direction];  
        this.y = y + dy[direction];
    }

    public Coordinate checkMove(int direction){  //calculate possible move in direaction
        return new Coordinate(x + dx[direction], y + dy[direction]);
    }

    @Override
    public String toString() { //to string method
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) { //compare two coordinates
        if (this == obj) return true;
        if (!(obj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) obj;
        return this.x == other.x && this.y == other.y;
    }

   
    
}
