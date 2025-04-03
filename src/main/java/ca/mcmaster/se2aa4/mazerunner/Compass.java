package ca.mcmaster.se2aa4.mazerunner;

public class Compass {


     // x-direction changes for going forward when facing: North, East, South, West
    protected int currentDirection; //current direction we are facing (0:North, 1:East, 2:South, 3:Right)
    // public Compass(int startDirection){ //initialize with start direction
    //     this.currentDirection = startDirection;
    // }
    // public Compass(){ //overlaod constructor to allow comppass intialization without Startdirection pre determined

    // }

    private static Compass compass = new Compass(); //initialize compass with default direction
     //current direction we are facing (0:North, 1:East, 2:South, 3:Right)
    private Compass(){ //initialize with start direction
        
    }
    public static Compass getInstance(){ //get instance of compass
        if(compass == null){ //if compass is not initialized
            compass = new Compass(); //initialize compass
        }
        return compass; //return compass
    }
    
    // public Compass(){ //overlaod constructor to allow comppass intialization without Startdirection pre determined

    // }

    //changes
    public void turnLeft() { //turn left
        currentDirection = (currentDirection + 3) % 4; //turn left
    }
    public void turnRight() { //turn right
        currentDirection = (currentDirection + 1) % 4; //turn right
    }
    public void turnAround() { //turn around
        currentDirection = (currentDirection + 2) % 4; //turn around
    }
    public int getCurrentDirection() { //get current direction
        return currentDirection; //return current direction
    }
    public void setCurrentDirection(int currentDirection) { //set current direction
        this.currentDirection = currentDirection; //set current direction
    }
   
}
