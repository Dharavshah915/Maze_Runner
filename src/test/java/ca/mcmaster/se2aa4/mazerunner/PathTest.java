package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PathTest {

    @Test
    public void pathInit(){ //use
        // Path path = new Path();
        // path.add("R");
        // path.add(" ");
        // path.add("F");
        // Assertions.assertEquals("R F",path.toString());
    }
    // @Test
    // public void test2(){
    //     Path path = new Path();
    //     path.add("R");
    //     path.add(" ");
    //     path.add("F");
    //     path.add("F");
    //     path.add("F");
    //     path.add("F");
    //     path.add(" ");
    //     path.add("L");
    //     path.CanonicalToFactorized();

    //     Assertions.assertEquals("R 4F L",path.toString());
    // }
    // @Test
    // public void test3(){
    //     Path path = new Path();
    //     path.add("R 4F L");
    //     path.factorizedtoCanonical();
    //     Assertions.assertEquals("R FFFF L ",path.toString());
    // }

    @Test void pathTurnLeft(){ // will make method for this in refactror as this is done in algs frequently
        // Path path = new Path();
        // //Simulate direction change the way it is done in algs
        // path.add(" "); //add instructions in canonical form
        // path.add("L");
        // path.add(" ");
        // path.add("F");

        // Assertions.assertEquals(" L F", path.toString());
    }

    

    @Test
    public void pathCompleteUpdateViaAlg(){
        // String inputFilePath = "./examples/straight.maz.txt";
        // Maze maze = new Maze(inputFilePath);
        // Player explorer = new Player(); //initialize player with empty path
        // Compass compass = new Compass(1); //initialize compass
        // Algorithm algorithm = new RHRAlgorithm(maze,compass); //choose algorithum of choice and initialize
        // explorer.get_Stratagy(algorithm); //provide algorithum to player
        // explorer.calculate_path(); //calculate path from maze
        // explorer.getPath();
        // Assertions.assertEquals("FFFF",explorer.getPath().toString());

    }
}
