package ca.mcmaster.se2aa4.mazerunner;

public class Maze {

    private char[][] grid;
    private int rows, columns;
    private int startRow, startColumn; // Atributes

    public Maze(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;
        this.startRow = 0;
        this.startColumn = 0;
        findEntryPoint(); // Constructors
    }

    public void findEntryPoint() { // Method to find entry point of maze
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == ' ') { // Look for a space in the first column
                startRow = i;
                startColumn = 0; // Assuming entry in first column for now
                return;
            }
        }
        throw new IllegalStateException("No entry point in maze"); // Error if no empty spaces in first column
    }

    public boolean wallCheck(int x, int y) { // Method to check if tile has a wall
        if (grid[x][y] == '#') {
            return true;
        } else {
            return false;
        }
    }

    public int sizeRow() { // get the number of rows in grid
        return rows;
    }

    public int sizeColumn() { // get number of columns in grid
        return columns;
    }

    public int getStartRow() {
        return startRow; // Get starting row
    }

    public int getStartColumn() {
        return startColumn; // Get starting column
    }

    public void playMaze(Movement user) { // Method to iterate through maze
        while (user.getColumn() != columns - 1) {
            int rightRow = user.getRightRow();
            int rightColumn = user.getRightColumn();
            int nextRow = user.getNextRow();
            int nextColumn = user.getNextColumn();

            if (!wallCheck(rightRow, rightColumn)) { // implementation of right hand algorithm
                user.turnRight();
                user.moveForward();
            } else if (!wallCheck(nextRow, nextColumn)) {
                user.moveForward();
            } else {
                user.turnLeft();
            }
        }
        user.displayPath();// Display factorized path
    }
}