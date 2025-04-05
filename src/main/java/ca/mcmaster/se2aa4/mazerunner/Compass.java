package ca.mcmaster.se2aa4.mazerunner;

public class Compass implements Observer{


    
    protected int currentDirection; //current direction we are facing (0:North, 1:East, 2:South, 3:Right)
  

    private static Compass compass; //singleton compass instance
    
    private Compass() { // private constructor without attaching
      
    }

    public static Compass getInstance() { //get instance of compass wih
        if (compass == null) { //if compass is not initialized
            compass = new Compass(); //initialize compass
        }
        return compass; //return compass
    }
    

    public void turnLeft() { //turn left
        currentDirection = (currentDirection + 3) % 4; 
    }
    public void turnRight() { //turn right
        currentDirection = (currentDirection + 1) % 4;
    }
    public void turnAround() { //turn around
        currentDirection = (currentDirection + 2) % 4; 
    }
    public int getCurrentDirection() { //get current direction
        return currentDirection;
    }
    public void setCurrentDirection(int currentDirection) { //set current direction
        this.currentDirection = currentDirection; 
    }
    @Override
    public void updateMoveRight() { //update move right
        this.turnRight();
    }

    @Override
    public void updateMoveLeft() { //update move left
        this.turnLeft();
    }

    @Override
    public void updateMoveForward() { //update move forward
       
    }

    @Override
    public void updateMoveBackward() { //update move backward
        this.turnAround();
    }
   
}
