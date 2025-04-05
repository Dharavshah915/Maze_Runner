package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompassTest {
    @Test
    public void compassInit(){ //use
        Compass compass = Compass.getInstance();
        compass.setCurrentDirection(1); //initialize compass
        Assertions.assertEquals(1, compass.getCurrentDirection()); //check if compass is initialized correctly
    }
    @Test
    public void compassRightTurn(){ //as done in algs, in refactor will make method for this
        Maze maze = Maze.getInstance(); //place holder objects to create RHR object
        Compass compass = Compass.getInstance(); //place holder object
        compass.setCurrentDirection(1);
        Algorithm algorithm = new RHRAlgorithm(maze, compass);
        algorithm.notifyObserversRight();

        Assertions.assertEquals(2, compass.currentDirection);
    }

    @Test
    public void compassLeftTurn(){  //as done in algs, in refactor will make method for this
        Maze maze = Maze.getInstance(); //place holder objects to create RHR object
        Compass compass = Compass.getInstance(); //place holder object
        compass.setCurrentDirection(0);
        Algorithm algorithm = new RHRAlgorithm(maze, compass);
        algorithm.notifyObserversLeft();

        Assertions.assertEquals(3, compass.currentDirection);
    }

    @Test
    public void compassBackTurn(){  //as done in algs, in refactor will make method for this
        Maze maze = Maze.getInstance(); //place holder objects to create RHR object
        Compass compass = Compass.getInstance(); //place holder object
        compass.setCurrentDirection(1);
        Algorithm algorithm = new RHRAlgorithm(maze, compass);
        algorithm.notifyObserversBackward();

        Assertions.assertEquals(3, compass.currentDirection);
    }


    
}
