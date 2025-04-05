package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PathTest {

    @Test
    public void pathInit(){ //use
        Path path = Path.getInstance();
        path.reset();
        path.add("R");
        path.add(" ");
        path.add("F");
        Assertions.assertEquals("R F",path.toString());
    }
    @Test
    public void pathUpdateReplicateAlgBack(){
        Maze maze = Maze.getInstance();
        Compass compass = Compass.getInstance();
        Algorithm algorithm = new RHRAlgorithm(maze, compass);
        Player explorer = Player.getInstance(algorithm);
        explorer.reset(); //reset explorer incase of previous instances still existing
        algorithm.notifyObserversBackward();
        Assertions.assertEquals(" B F", explorer.getPath().toString());
       
    }

    @Test
    public void pathUpdateReplicateAlgForward(){
        Maze maze = Maze.getInstance();
        Compass compass = Compass.getInstance();
        Algorithm algorithm = new RHRAlgorithm(maze, compass);
        Player explorer = Player.getInstance(algorithm);
        explorer.reset(); //reset explorer incase of previous instances still existing
        algorithm.notifyObserversForward();
        Assertions.assertEquals("F", explorer.getPath().toString());
       
    }
    @Test
    public void pathUpdateReplicateAlgTurnRight(){
        Maze maze = Maze.getInstance(); //place holder objects to create RHR object
        Compass compass = Compass.getInstance(); //place holder object
        compass.setCurrentDirection(1);
        Algorithm algorithm = new RHRAlgorithm(maze, compass);
        Player explorer = Player.getInstance(algorithm);
        explorer.reset(); //reset explorer incase of previous instances still existing
        algorithm.notifyObserversRight();

        Assertions.assertEquals(" R F", explorer.getPath().toString());
    }

    @Test 
    public void pathUpdateReplicateAlgTurnLeft(){ 
        Maze maze = Maze.getInstance();
        Compass compass = Compass.getInstance();
        Algorithm algorithm = new RHRAlgorithm(maze, compass);
        Player explorer = Player.getInstance(algorithm);
        explorer.reset(); //reset explorer incase of previous instances still existing
        algorithm.notifyObserversLeft();
        Assertions.assertEquals(" L F", explorer.getPath().toString());
       
    }

    

    @Test
    public void pathUpdateViaCalculatePath(){
        String inputFilePath = "./examples/straight.maz.txt";
        Maze maze = Maze.getInstance();
        maze.load_info(inputFilePath);
        Compass compass = Compass.getInstance(); //initialize compass
        compass.setCurrentDirection(1);
        Algorithm algorithm = new RHRAlgorithm(maze,compass);
        Player explorer = Player.getInstance(algorithm); //initialize player with empty path
        explorer.reset(); //reset explorer incase of previous instances still existing
        explorer.get_Stratagy(algorithm); //provide algorithum to player
        explorer.calculate_path(); //calculate path from maze
        explorer.getPath();
        Assertions.assertEquals("FFFF",explorer.getPath().toString());

    }
}
