package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class RHRAlgorithm extends Algorithm {
   
    public RHRAlgorithm(Maze maze, Compass compass) { //initialize with maze and start direction for compass
        super(maze, compass);
    }

    @Override
    public ArrayList<String> findPath(int startDirection) { //overide abstart method
        ArrayList<String> path = new ArrayList<>();
        if(startDirection==1){ //if starting from West change End and Current(Start coordinates) as needed
            this.EndCoord = maze.getEnd();
            this.CurrentCoord = maze.getStart();
        }else{ //if starting from East change End and Current(Start coordinates) as needed
            this.EndCoord = maze.getStart();
            this.CurrentCoord = maze.getEnd();
            // this.EndY = maze.getStartY();
            // this.currentX = maze.getEndX();
            // this.currentY = maze.getEndY();
        }
        

        while (!MazeUtils.isSolved(EndCoord, CurrentCoord)) { //while maze has not been solved
            
            int rightDirection = (compass.getCurrentDirection() + 1) % 4; // calculate new direction if we were turning right
            Coordinate possibleMove = CurrentCoord.checkMove(rightDirection); //calculate possible move
            // int rightX = currentX + dx[rightDirection]; //calculate possible move
            // int rightY = currentY + dy[rightDirection];

            if (MazeUtils.isValidMove(maze,possibleMove)) { //try to turn right
                compass.turnRight(); //update directions
                CurrentCoord.move(rightDirection); //update coords
                // currentX = rightX; //update coords
                // currentY = rightY;
                path.add(" "); //add instructions in canonical form
                path.add("R");
                path.add(" ");
                path.add("F");

            } else {
                //direction is not altered if we moce forward
                possibleMove = CurrentCoord.checkMove(compass.getCurrentDirection());
                // int straightX = currentX + dx[currentDirection];  //calculate possible move
                // int straightY = currentY + dy[currentDirection];

                if (MazeUtils.isValidMove(maze,possibleMove)) { //try to go forward
                    CurrentCoord.move(compass.getCurrentDirection()); //update coords
                    path.add("F"); //add instructions in canonical form

                } else {

                    int leftDirection = (compass.getCurrentDirection() + 3) % 4; // calculate new direction if we were turning left
                    possibleMove = CurrentCoord.checkMove(leftDirection);
                    // int leftX = currentX + dx[leftDirection];  //calculate possible move
                    // int leftY = currentY + dy[leftDirection];

                    if (MazeUtils.isValidMove(maze,possibleMove)){ //try to turn left
                        compass.turnLeft(); //update directions
                        // currentDirection = leftDirection; //update directions
                        CurrentCoord.move(leftDirection); //update coords
                        // currentX = leftX; //update coords
                        // currentY = leftY;
                        path.add(" "); //add instructions in canonical form
                        path.add("L");
                        path.add(" ");
                        path.add("F");
                    } else{
                        int backDirection = (compass.getCurrentDirection() + 2) % 4; // calculate new direction to turn back
                        CurrentCoord. move(backDirection);
                        // int backX = currentX + dx[backDirection]; //calculate new move
                        // int backY = currentY + dy[backDirection];
                        compass.turnAround(); //update directions
                        //currentDirection = backDirection; //update directions
                        // currentX = backX; //update coords
                        // currentY = backY;
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
