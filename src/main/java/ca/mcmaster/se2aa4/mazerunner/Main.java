package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", true, "Maze file");

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            if (!cmd.hasOption("i")) {
                logger.info("Use -i flag to input maze file");
                return;
            }

            String mazeFile = cmd.getOptionValue("i");

            logger.info("**** Reading the maze from file " + mazeFile);
            BufferedReader reader = new BufferedReader(new FileReader(mazeFile));

            List<char[]> mazeRows = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                char[] row = line.toCharArray();
                mazeRows.add(row);
                
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        logger.debug("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        logger.debug("PASS ");
                    }
                }
                logger.debug(System.lineSeparator());
            }
            reader.close();
            logger.info("**** Computing path");
            char[][] grid = mazeRows.toArray(new char[0][]);
            Maze maze = new Maze(grid);

            maze.playMaze();

        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!\\", e);
            logger.error("PATH NOT COMPUTED");
            logger.info("** End of MazeRunner");
        }
    }
}