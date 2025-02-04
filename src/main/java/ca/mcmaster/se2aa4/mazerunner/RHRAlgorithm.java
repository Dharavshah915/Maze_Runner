package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class RHRAlgorithm extends Algorithm {
   
    public RHRAlgorithm(Maze maze, int startDirection) { //initialize with maze and start direction for compass
        super(maze, startDirection);
    }

    @Override
    public ArrayList<String> findPath(int startDirection) { //overide abstart method
        ArrayList<String> path = new ArrayList<>();
        if(startDirection==1){ //if starting from West change End and Current(Start coordinates) as needed
            this.EndX = maze.getEndX();
            this.EndY = maze.getEndY();
            this.currentX = maze.getStartX();
            this.currentY = maze.getStartY();
        }else{ //if starting from East change End and Current(Start coordinates) as needed
            this.EndX = maze.getStartX();
            this.EndY = maze.getStartY();
            this.currentX = maze.getEndX();
            this.currentY = maze.getEndY();
        }
        

        while (!MazeUtils.isSolved(EndX, EndY,currentX, currentY)) { //while maze has not been solved
            
            int rightDirection = (currentDirection + 1) % 4; // calculate new direction if we were turning right
            int rightX = currentX + dx[rightDirection]; //calculate possible move
            int rightY = currentY + dy[rightDirection];

            if (MazeUtils.isValidMove(maze,rightX, rightY)) { //try to turn right
                currentDirection = rightDirection; //update directions
                currentX = rightX; //update coords
                currentY = rightY;
                path.add(" "); //add instructions in canonical form
                path.add("R");
                path.add(" ");
                path.add("F");

            } else {
                //direction is not altered if we moce forward
                int straightX = currentX + dx[currentDirection];  //calculate possible move
                int straightY = currentY + dy[currentDirection];

                if (MazeUtils.isValidMove(maze,straightX, straightY)) { //try to go forward
                    currentX = straightX; //update new coords
                    currentY = straightY;
                    path.add("F"); //add instructions in canonical form

                } else {

                    int leftDirection = (currentDirection + 3) % 4; // calculate new direction if we were turning left
                    int leftX = currentX + dx[leftDirection];  //calculate possible move
                    int leftY = currentY + dy[leftDirection];

                    if (MazeUtils.isValidMove(maze,leftX, leftY)){ //try to turn left

                        currentDirection = leftDirection; //update directions
                        currentX = leftX; //update coords
                        currentY = leftY;
                        path.add(" "); //add instructions in canonical form
                        path.add("L");
                        path.add(" ");
                        path.add("F");
                    } else{
                        int backDirection = (currentDirection + 2) % 4; // calculate new direction to turn back
                        int backX = currentX + dx[backDirection]; //calculate new move
                        int backY = currentY + dy[backDirection];
        
                        currentDirection = backDirection; //update directions
                        currentX = backX; //update coords
                        currentY = backY;
                        path.add(" "); //add instructions in canonical form
                        path.add("B");
                        path.add(" ");
                        path.add("F");
                    }

                }
            }
        }
        return path;
    }
}
