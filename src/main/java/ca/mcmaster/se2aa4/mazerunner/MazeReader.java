package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.ArrayList;

public class MazeReader {

    private static final Logger logger = LogManager.getLogger();

    public static char[][] readMaze(String mazeFile) {
        try {
            logger.info("**** Reading the maze from file " + mazeFile);
            BufferedReader reader = new BufferedReader(new FileReader(mazeFile));

            List<char[]> mazeRows = new ArrayList<>(); // list to store rows of maze file

            String line;

            while ((line = reader.readLine()) != null) { // reading maze from file
                char[] row = line.toCharArray();
                mazeRows.add(row); // adding row to list

                for (int idx = 0; idx < line.length(); idx++) { // iterating through each character in line
                    if (line.charAt(idx) == '#') {
                        logger.debug("WALL "); // check and log for wall
                    } else if (line.charAt(idx) == ' ') {
                        logger.debug("PASS "); // check and log for empty space
                    }
                }
                logger.debug(System.lineSeparator());
            }
            reader.close();

            return mazeRows.toArray(new char[0][]);
        } catch (Exception e) {
            logger.error("Error has occured");
        }
        return new char[0][0];
    }
}
