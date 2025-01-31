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
                //System.out.print(System.lineSeparator());
            }

            logger.info("**** Computing path");
            try {
                cmd = parser.parse(options, args);
                //String inputFilePath = cmd.getOptionValue("i");
                Maze maze = new Maze(inputFilePath);
                System.out.println("maze got");
                int startDirection = 1;
                
            
                if (cmd.hasOption("p")){
                    String route = cmd.getOptionValue("p");
                    Path path = new Path(route);
                    Player explorer = new Player(path);
                    PathValidation validator = new PathValidation(maze, startDirection, explorer.path);
                    boolean correctPath = validator.validatePath();
                    //boolean correctPath = explorer.verrify(cmd.getOptionValue("p"));
                    logger.info(correctPath);
                }else{
                    Player explorer = new Player();
                    Algorithm algorithm = new RHRAlgorithm(maze,startDirection);
                    explorer.get_Stratagy(algorithm);
                    logger.trace(maze.getStartX());
                    logger.trace(maze.getStartY());
                    logger.trace(maze.getEndX());
                    logger.trace(maze.getEndY());
                    explorer.get_path();
                    explorer.path.CanonicalToFactorized();
                    logger.info(explorer.path);
                }
            
            } catch (Exception e) {
                System.out.println(e);
                logger.info("PATH NOT COMPUTED");
            }


        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.error(e);
        }
        
    
        logger.info("** End of MazeRunner");
    }
}
