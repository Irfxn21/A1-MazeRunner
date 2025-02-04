package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", true, "Maze file");
        options.addOption("p", true, "Maze path"); // Flags to be detected

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            if (!cmd.hasOption("i")) {
                logger.error("Use -i flag to input maze file"); // Logs error if i flag not detected
            }

            String mazeFile = cmd.getOptionValue("i"); // storing name of file

            char[][] grid = MazeReader.readMaze(mazeFile); // reading maze file and storing in 2d array
            Maze maze = new Maze(grid); // create an object in Maze
            Movement user = new Movement(maze.getStartRow(), maze.getStartColumn()); // create an object in Movement

            if (cmd.hasOption("p")) { // Check for p flag
                String givenPath = cmd.getOptionValue("p"); // Storing given path
                logger.info("**** Verifying path");

                PathChecker checkPath = new PathChecker(maze, user); // Creates obect in PathChecker
                checkPath.verifyPath(givenPath); // Verify given path

            } else {
                logger.info("**** Computing path");

                maze.playMaze(user); // Method to calculate and display factorized path of given maze
            }

        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!\\", e);
            logger.error("PATH NOT COMPUTED");
            logger.info("** End of MazeRunner"); // Error handling if incorrect input
        }
    }
}