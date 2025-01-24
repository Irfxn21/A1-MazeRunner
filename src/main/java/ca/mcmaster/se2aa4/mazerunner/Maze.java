package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Maze {

    private char[][] grid;
    private int rows, columns;
    private int startRow, startColumn;
    private char startDirection;


    private void findEntryPoint() {
        for (int i=0; i<rows; i++) {
            if (grid[i][0] == ' ') {
                startRow = i;
                startColumn = 0;
                startDirection = 'E';
                return
            }
        }
        logger.info("No entry point in maze")
    }
}