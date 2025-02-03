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

    public boolean wallCheck(int x, int y) {
        if (grid[x][y] == '#') {
            return true;
        } else {
            return false;
        }
    }

    public int getStartRow() {
        return startRow; // Get sratinging row
    }

    public int getStartColumn() {
        return startColumn; // Get starting column
    }

    public void playMaze() { // Method to iterate through spaces in maze and produce canonical path

        findEntryPoint();
        User user = new User(getStartRow(), getStartColumn()); // Create object in User
        while (user.getColumn() != columns - 1) {
            int rightRow = user.getRightRow();
            int rightColumn = user.getRightColumn();
            int nextRow = user.getNextRow();
            int nextColumn = user.getNextColumn();

            if (!wallCheck(rightRow, rightColumn)) {
                user.turnRight();
                user.moveForward(); // Method to move forward in maze
            } else if (!wallCheck(nextRow, nextColumn)) {
                user.moveForward();
            } else {
                user.turnLeft();
            }
        }
        user.canonicalPath(); // Method to display canonical path
        user.factorizedPath(); // Method to display factorized path
    }
}