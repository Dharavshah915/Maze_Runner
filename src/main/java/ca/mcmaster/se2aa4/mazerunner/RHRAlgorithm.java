package ca.mcmaster.se2aa4.mazerunner;

public class RHRAlgorithm extends Algorithm {
   
    public RHRAlgorithm(Maze maze, Compass compass) { //initialize with maze and start direction for compass
        super(maze, compass);
        if(this.getCompass().getCurrentDirection() ==3){ //if starting from West(30) Swap End and Current(Start coordinates) as needed
           
            this.maze.SwapStartEnd();
        }
        this.CurrentCoord = maze.getStart();
    }

    @Override
    public void findPath() { //overide abstart method

        while (!MazeUtils.isSolved(this.getEndCoord(), CurrentCoord)) { //while maze has not been solved

            int rightDirection = (compass.getCurrentDirection() + 1) % 4; // calculate new direction if we were turning right
            Coordinate possibleMove = CurrentCoord.checkMove(rightDirection); //calculate possible move
          
            if (MazeUtils.isValidMove(maze,possibleMove)) { //try to turn right
                CurrentCoord.move(rightDirection); //update coords
                notifyObserversRight();

            } else {
                possibleMove = CurrentCoord.checkMove(compass.getCurrentDirection()); //calculate possible move forward
           

                if (MazeUtils.isValidMove(maze,possibleMove)) { //try to go forward
                    CurrentCoord.move(compass.getCurrentDirection());
                    notifyObserversForward(); //notify 

                } else {
                    int leftDirection = (compass.getCurrentDirection() + 3) % 4; // calculate new direction if we were turning left
                    possibleMove = CurrentCoord.checkMove(leftDirection);
                

                    if (MazeUtils.isValidMove(maze,possibleMove)){ //try to turn left
                        CurrentCoord.move(leftDirection); //update coords
                        notifyObserversLeft(); //notify

                    } else{
                        int backDirection = (compass.getCurrentDirection() + 2) % 4; // calculate new direction to turn back
                        CurrentCoord.move(backDirection);
                        notifyObserversBackward(); //notify
                    }
                }
            }
        }
    }
}
