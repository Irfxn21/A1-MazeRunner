package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Maze {

    private char[][] grid;
    private int rows, columns;
    private int startRow, startColumn;
    private char startDirection;

    public Maze() {

    }


    private void findEntryPoint() {
        for (int i=0; i<rows; i++) {
            if (grid[i][0] == ' ') {
                startRow = i;
                startColumn = 0;
                return
            }
        }
        logger.info("No entry point in maze")
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    pubic char[][] getGrid() {
        reutrn grid;
    }


}   