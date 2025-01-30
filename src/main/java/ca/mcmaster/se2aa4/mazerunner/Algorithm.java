package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public abstract class Algorithm extends Compass {
    //protected final int[] dy = {-1, 0, 1, 0}; // x-direction changes for Up, Right, Down, Left
    //protected final int[] dx = {0, 1, 0, -1};
    protected Maze maze;
    //protected int startX, startY, endX, endY;
    protected int currentX, currentY;
    //protected int currentDirection;


    // Constructor to initialize the algorithm with the maze
    public Algorithm(Maze maze, int startDirection) {
        
        
        // this.endX = maze.getEndX();
        // this.endY = maze.getEndY();
        super(startDirection);
        this.maze = maze;
        //this.startX = maze.getStartX();
        //this.startY = maze.getStartY();
        this.currentX = maze.getStartX();
        this.currentY = maze.getStartY();
        //this.currentDirection = 1; // Default to starting direction 1:(East)  2:South 3:West 4: North
    }


    public boolean validatePath(String path){
      for(char dir: path.trim().toCharArray()){
          switch (dir) {

            case 'F':
                currentX += dx[currentDirection];
                currentY += dy[currentDirection];
                if (!MazeUtils.isValidMove(maze,currentX, currentY)){
                    return false;
                }
                break;
            case 'R':
                currentDirection = (currentDirection + 1) % 4;
                break;
            case 'B':
                currentDirection = (currentDirection + 2) % 4;
                break;
            case 'L':
                currentDirection = (currentDirection + 3) % 4;
                break;
            case ' ':
                break; //pass if
        
            default:
                return false;
          }
      }
      return MazeUtils.isSolved(maze,currentX, currentY);
    }
    
    public abstract ArrayList<String> findPath();

    

}
