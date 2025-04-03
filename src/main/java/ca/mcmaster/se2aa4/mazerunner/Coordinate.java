package ca.mcmaster.se2aa4.mazerunner;

public class Coordinate {

    protected final int[] dy = {-1, 0, 1, 0}; // x-direction change for going forward when facing: North, East, South, West
    protected final int[] dx = {0, 1, 0, -1};
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int direction){
        this.x = x + dx[direction];  //calculate possible move
        this.y = y + dy[direction];
    }

    public Coordinate checkMove(int direction){
        return new Coordinate(x + dx[direction], y + dy[direction]);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) obj;
        return this.x == other.x && this.y == other.y;
    }
    
}
