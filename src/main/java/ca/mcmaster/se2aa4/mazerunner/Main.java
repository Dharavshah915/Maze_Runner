package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) { 
        logger.info("Starting Maze Runner");
        

        Options options = new Options();
        options.addOption("i", true, "maze file");
        options.addOption("p", true, "Solution");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd ;

        
        try {
            cmd = parser.parse(options, args);
            String inputFilePath = cmd.getOptionValue("i");

            if (inputFilePath == null || inputFilePath.isEmpty()) {
                logger.error("No maze file path provided. Please specify -i option with a valid file path.");
                return; // Exit if no file path
            }
            logger.info("**** Reading the maze from file " + inputFilePath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            String line;

            StringBuilder myTraceLogs = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                myTraceLogs.setLength(0);
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        myTraceLogs.append("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        myTraceLogs.append("PASS ");
                    }
                    
                }
                logger.trace(myTraceLogs.toString().trim());
            }
 //----------------------------------------------------------------------------------

            logger.info("**** Computing path");
            try {
                int startDirection = 1; //change as needed 1 = start from West side, 3 = start from East for maze solving
                Compass compass = Compass.getInstance();
                compass.setCurrentDirection(startDirection); //set compass
                cmd = parser.parse(options, args);
                Maze maze = Maze.getInstance(); //initilaize maze
                maze.load_info(inputFilePath);
 
                
                if (cmd.hasOption("p")){ 
                    String route = cmd.getOptionValue("p"); //get route from input
                    PathValidation validator = PathValidation.getInstance(); //Initilize path validiator
                    validator.setPath(route); //set maze and path for validation
                    boolean isCorrectPathFromRight = validator.validatePath(1); //check if path is valid from left side
                    boolean isCorrectPathFromLeft = validator.validateCanonicalPath(3); //chekc if path is valid from right side
                    System.out.println(isCorrectPathFromLeft || isCorrectPathFromRight ? "That is a valid path" : "That path is not valid");

                }else{
                    Algorithm algorithm = new RHRAlgorithm(maze,compass); //choose algorithum of choice and initialize
                    Player explorer = Player.getInstance(algorithm);
                    explorer.calculate_path(); //calculate path from maze
                    explorer.getPath().CanonicalToFactorized(); //change to factorized form
                    System.out.println(explorer.getPath()); //output
                }
            
            } catch (Exception e) {
                logger.info(e);
                logger.info("PATH NOT COMPUTED");
            }


        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.error(e);
        }
        
    
        logger.info("** End of MazeRunner");
    }
}
