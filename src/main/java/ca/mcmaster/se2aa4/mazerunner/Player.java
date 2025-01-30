package ca.mcmaster.se2aa4.mazerunner;

public class Player {
    //public int x, y;   //position in maze
    //private int direction; //direction facing 0 = North, 1 = East, 2 = south, 3 = West
    public Path path;
    public Algorithm stratagy;
    //protected final int[] dy = {-1, 0, 1, 0}; 
    //protected final int[] dx = {0, 1, 0, -1};
    //public boolean doneMaze = false;


    //private final Maze maze;

    public Player() {
        this.path = new Path();
        //this.maze = maze;
        //this.x = maze.getStartX();
        //this.y = maze.getStartY();
    }

    // public void followMove(String move) {
    //         switch (move) {
    //             case "F":
    //                 moveForward();
    //                 break;
    //             case "L":
    //                 turnLeft();
    //                 break;
    //             case "R":
    //                 turnRight();
    //                 break;
    //             case "B":
    //                 turnBack();
    //                 break;
    //         }
    // }

    // private void moveForward() {
    //     //x += dx[direction];
    //     //y += dy[direction];
    //     path += "F";
    //     //isAtEnd();
    // }

    // private void turnLeft() {
    //     //direction = (direction + 3) % 4; // Turn counter-clockwise
    //     path += "L";
    //     //isAtEnd();
    // }

    // private void turnRight() {
    //     //direction = (direction + 1) % 4; // Turn clockwise
    //     path += "R";
    //     //isAtEnd();
    // }

    // public void turnBack(){
    //     //direction = (direction + 2) % 4; // Turn clockwise
    //     path += "B";
    //     //isAtEnd();
    // }

    // public void isAtEnd() {
    //     if (x == maze.getEndX() && y == maze.getEndY()){
    //         doneMaze = true;
    //     }
    // }

    public void get_Stratagy(Algorithm algorithm){
        this.stratagy = algorithm;
    }

    public void get_path(){
        this.path.pathway = String.join("", this.stratagy.findPath());
    }

    public boolean verrify(String path){
        return(this.stratagy.validatePath(path));
    }
}