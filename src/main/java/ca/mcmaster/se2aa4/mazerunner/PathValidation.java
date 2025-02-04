package ca.mcmaster.se2aa4.mazerunner;

public class PathValidation extends Compass {
    Maze maze;
    Path path;
    protected int currentX, currentY;
    protected int EndY, EndX;

    public PathValidation(Maze maze, Path path){
        super();
        this.maze = maze;
        this.path = path;
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
            this.EndX = maze.getEndX();
            this.EndY = maze.getEndY();
            this.currentX = maze.getStartX();
            this.currentY = maze.getStartY();
        }else{  //if starting from East change End and Current(Start coordinates) as needed 
            this.EndX = maze.getStartX();
            this.EndY = maze.getStartY();
            this.currentX = maze.getEndX();
            this.currentY = maze.getEndY();
        }
        super.currentDirection = startDirection; //set compass
        for(char dir: path.pathway.trim().toCharArray()){
            switch (dir) {

            case 'F': //move forwards
                currentX += dx[currentDirection]; //add to x and y to move forwards according to direction being faced
                currentY += dy[currentDirection];
                if (!MazeUtils.isValidMove(maze,currentX, currentY)){ //if any move is not valid
                    return false;
                }
                break;
            //change direction if R, B, or, L encountered
            case 'R': //turn right
                currentDirection = (currentDirection + 1) % 4; 
                break;
            case 'B': //turn back
                currentDirection = (currentDirection + 2) % 4;
                break;
            case 'L': //turn left
                currentDirection = (currentDirection + 3) % 4;
                break;
            //if there is a space continue
            case ' ':
                break; //pass if
            //if there is any other character return false
            default:
                return false;
            }
    }
    return MazeUtils.isSolved(EndX, EndY,currentX, currentY); //check if end coords have been reached at the end
    }

    public boolean validateFactorizedPath(int startDirection){ //check if factorized path is valid
        path.factorizedtoCanonical(); //convert to Canonical
        return(validateCanonicalPath(startDirection)); //check validation of canonical path
    }



    


}
