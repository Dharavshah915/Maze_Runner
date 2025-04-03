package ca.mcmaster.se2aa4.mazerunner;

public class PathValidation {
    Maze maze;
    Path path;
    private Coordinate CurrentCoord; 
    private Coordinate EndCoord;
    private Compass compass;
    private static PathValidation instance; //singleton instance
    // Assuming Coordinate is a class with a getX() method
    // protected int currentX, currentY;
    // protected int EndY, EndX;

    private PathValidation(){
        this.compass = Compass.getInstance(); //initialize compass
    }

    public static PathValidation getInstance(){ //get instance of path validation
        if(instance == null){ //if instance is not initialized
            instance = new PathValidation(); //initialize instance
        }
        return instance; //return instance
    }

    public void setMazeAndPath(Maze maze, Path path){ //set maze and path
        this.maze = maze; //set maze
        this.path = path; //set path
    }
    

    public boolean validatePath(int startDirection){ //check if path is valid
        boolean isCanonical = true; 
        for(char dir: path.pathway.trim().toCharArray()){ //check if it is in canonical form by searching for any digits
            if (Character.isDigit(dir)){
                isCanonical = false;
                break;
            }
        }
        if (isCanonical){ //use the methods needed based on path form
            return(validateCanonicalPath(startDirection));
        }else{
            return validateFactorizedPath(startDirection);
        }
    }

    public boolean validateCanonicalPath(int startDirection){//check if canonical path is valid
       if(startDirection==1){ //if starting from West change End and Current(Start coordinates) as needed
            this.EndCoord = maze.getEnd();
            this.CurrentCoord = maze.getStart();
        }else{ //if starting from East change End and Current(Start coordinates) as needed
            this.EndCoord = maze.getStart();
            this.CurrentCoord = maze.getEnd();                             //copied from lag in case of issue
            // this.EndY = maze.getStartY();
            // this.currentX = maze.getEndX();
            // this.currentY = maze.getEndY();
        }
        compass.setCurrentDirection(startDirection); //set compass
        //super.currentDirection = startDirection; //set compass
        for(char dir: path.pathway.trim().toCharArray()){
            switch (dir) {

            case 'F': //move forwards
                CurrentCoord.move(compass.getCurrentDirection()); //update coords
                // currentX += dx[currentDirection]; //add to x and y to move forwards according to direction being faced
                // currentY += dy[currentDirection];
                if (!MazeUtils.isValidMove(maze,CurrentCoord)){ //if any move is not valid
                    return false;
                }
                break;
            //change direction if R, B, or, L encountered
            case 'R': //turn right
                compass.turnRight(); //update direction
                //currentDirection = (currentDirection + 1) % 4; 
                break;
            case 'B': //turn back
                compass.turnAround();
                //currentDirection = (currentDirection + 2) % 4;
                break;
            case 'L': //turn left
                compass.turnLeft(); //update direction
                //currentDirection = (currentDirection + 3) % 4;
                break;
            //if there is a space continue
            case ' ':
                break; //pass if
            //if there is any other character return false
            default:
                return false;
            }
    }
    return MazeUtils.isSolved(EndCoord, CurrentCoord); //check if end coords have been reached at the end
    }

    public boolean validateFactorizedPath(int startDirection){ //check if factorized path is valid
        path.factorizedtoCanonical(); //convert to Canonical
        return(validateCanonicalPath(startDirection)); //check validation of canonical path
    }



    


}
