package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MazeTest {
    @Test
    public void mazeInitTest(){ 
        String inputFilePath = "./examples/regular.maz.txt";
        Maze maze = Maze.getInstance();
        maze.reset();//reset incase singleton instance was initialized elsewhere
        maze.load_info(inputFilePath); //initialize maze
        int height = maze.getHeight();
        int width = maze.getWidth();
        Assertions.assertEquals(41, height);
        Assertions.assertEquals(41, width);
        int startX = maze.getStartX();
        int startY = maze.getStartY();
        int endX = maze.getEndX();
        int endY = maze.getEndY();
        Assertions.assertEquals(0, startX);
        Assertions.assertEquals(33, startY);
        Assertions.assertEquals(40, endX);
        Assertions.assertEquals(27, endY);
    }
    
    
}
