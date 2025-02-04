package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", true, "Maze file"); // Flag to be detected
        options.addOption("p", true, "Maze path"); // Flag to be detected

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd1 = parser.parse(options, args);
            CommandLine cmd2 = parser.parse(options, args);

            if (!cmd1.hasOption("i")) {
                logger.info("Use -i flag to input maze file");
                return;
            }

            String mazeFile = cmd1.getOptionValue("i"); // storing name of file

            char[][] grid = MazeReader.readMaze(mazeFile);
            Maze maze = new Maze(grid); // create an object in Maze
            Movement user = new Movement(maze.getStartRow(), maze.getStartColumn()); // create an object in User

            if (cmd2.hasOption("p")) { // Check for p flag
                String givenPath = cmd2.getOptionValue("p"); // Storing given path
                logger.info("**** Verifying path");

                PathChecker checkPath = new PathChecker(maze, user);
                checkPath.verifyPath(givenPath);

            } else {
                logger.info("**** Computing path");

                maze.playMaze(user); // Method to calculate and display canonical path of given maze
            }

        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!\\", e);
            logger.error("PATH NOT COMPUTED");
            logger.info("** End of MazeRunner"); // Error handling if incorrect input
        }
    }
}