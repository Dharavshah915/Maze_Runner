package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompassTest {
    @Test
    public void compassInit(){ //use
        // Compass compass = new Compass(1);
        // compass.currentDirection = 1;
        // Assertions.assertEquals(1, compass.currentDirection);
    }
    @Test
    public void compassRightTurn(){ //as done in algs, in refactor will make method for this
        // int startDirection = 1;
        // Compass compass = new Compass(startDirection);
        // int rightTurn = (compass.currentDirection + 3) % 4;
        // compass.currentDirection = rightTurn;
        
        // Assertions.assertEquals(0, compass.currentDirection);
    }
    @Test
    public void compassLeftTurn(){  //as done in algs, in refactor will make method for this
        // int startDirection = 1;
        // Compass compass = new Compass(startDirection);
        // int leftTurn = (compass.currentDirection + 1) % 4;
        // compass.currentDirection = leftTurn;
        
        // Assertions.assertEquals(2, compass.currentDirection);
    }

    @Test
    public void compassBackTurn(){  //as done in algs, in refactor will make method for this
        // int startDirection = 1;
        // Compass compass = new Compass(startDirection);
        // int backTurn = (compass.currentDirection + 2) % 4;
        // compass.currentDirection = backTurn;
        
        // Assertions.assertEquals(3, compass.currentDirection);
    }


    
}
