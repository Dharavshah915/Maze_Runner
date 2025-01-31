package ca.mcmaster.se2aa4.mazerunner;

public class PathValidation extends Compass {
    Maze maze;
    protected int currentX, currentY;
    Path path;
    public PathValidation(Maze maze, int direction, Path path){
        super(direction);
        this.maze = maze;
        this.currentX = maze.getStartX();
        this.currentY =  maze.getStartY();
        this.path = path;
    }

    public boolean validatePath(){
        System.out.println("one");
        boolean isCanonical = true; 
        for(char dir: path.pathway.trim().toCharArray()){
            if (Character.isDigit(dir)){
                isCanonical = false;
                break;
            }
        }
        if (isCanonical){
            return(validateCanonicalPath());
        }else{
            return validateFactorizedPath();
        }
    }

    public boolean validateCanonicalPath(){
        System.out.println(path.pathway);
        System.out.println("here");
        for(char dir: path.pathway.trim().toCharArray()){
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

    public boolean validateFactorizedPath(){
        path.factorizedtoCanonical();
        System.out.println(path.pathway);
        return(validateCanonicalPath());
    }



    


}
