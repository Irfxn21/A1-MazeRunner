package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Maze {

    private char[][] grid;
    private int rows, columns;
    private int startRow, startColumn;

    public Maze(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;
        this.startRow = 0;
        this.startColumn = 0;
        findEntryPoint();
    }

    public void findEntryPoint() {
    for (int i = 0; i < rows; i++) {
        if (grid[i][0] == ' ') { // Look for a space in the first column
            startRow = i;
            startColumn = 0; // Entry is always in the first column
            return;
        }
    }
    throw new IllegalStateException("No entry point in maze");
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public void playMaze() {
        User user = new User(getStartRow(), getStartColumn());

        while(user.getColumn() != columns-1) {
            user.moveForward();
        }
        user.canonicalPath();
    }
}   