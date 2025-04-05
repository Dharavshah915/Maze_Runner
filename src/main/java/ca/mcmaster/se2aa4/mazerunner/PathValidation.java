package ca.mcmaster.se2aa4.mazerunner;

public class PathValidation {
    Maze maze;
    Path path;
    private Coordinate CurrentCoord; //current Poisiton
    private Coordinate EndCoord; //end position
    private Compass compass; //compass
    private static PathValidation instance; //singleton instance


    private PathValidation(){
        this.compass = Compass.getInstance(); //initialize compass
        this.path = Path.getInstance(); //initialize path
        this.maze = Maze.getInstance(); //initialize maze
    }

    public static PathValidation getInstance(){ //get instance of path validation
        if(instance == null){ //if instance is not initialized
            instance = new PathValidation(); //initialize instance
        }
        return instance; //return instance
    }

    public void setPath(String path){ //set path to validate
        this.path.setPath(path); 
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
            this.CurrentCoord = maze.getEnd();    
      
        }
        compass.setCurrentDirection(startDirection); //set compass
      
        for(char dir: path.pathway.trim().toCharArray()){
            switch (dir) {

            case 'F': //move forwards
                CurrentCoord.move(compass.getCurrentDirection()); //update coords
                if (!MazeUtils.isValidMove(maze,CurrentCoord)){ //if any move is not valid
                    return false;
                }
                break;
 
            case 'R': //turn right
                compass.turnRight(); //update direction
         
                break;
            case 'B': //turn back
                compass.turnAround();
           
                break;
            case 'L': //turn left
                compass.turnLeft(); //update direction
         
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
