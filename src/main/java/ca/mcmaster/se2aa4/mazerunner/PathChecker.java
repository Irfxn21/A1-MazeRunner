package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker { // Class to verify given path

    private Maze maze;
    private Movement user; // Attributes

    public PathChecker(Maze maze, Movement user) {
        this.maze = maze;
        this.user = user; // Constructors
    }

    public boolean verifyPath(String path) { // Method to verify path
        String canonicalPath = expandPath(path); // Converts given path into canonical form
        for (char i : canonicalPath.toCharArray()) { // iterates through each move
            if (i == 'F') {
                int nextRow = user.getNextRow();
                int nextColumn = user.getNextColumn();

                if (maze.wallCheck(nextRow, nextColumn)) { // Checks if move leads to a wall
                    System.out.println("Incorrect Path");
                    return false;
                }
                user.moveForward();
            } else if (i == 'R') {
                user.turnRight();
            } else if (i == 'L') {
                user.turnLeft();
            } else if (i == ' ') {
                System.out.println("Space");
            } else {
                System.out.println("Incorrect Path");
                return false;
            }
        }

        if (user.getColumn() == maze.sizeColumn() - 1) { // Checks if user is at the end of the maze
            System.out.println("Correct Path");
            return true;
        } else {
            System.out.println("Incorrect Path");
            return false;
        }
    }

    private String expandPath(String path) { // Method to convert factorized path into canonical

        String expanded = "";
        String number = "";

        for (char i : path.toCharArray()) { // Stores given path in array of characters
            if (Character.isDigit(i)) { // Checks if character is a digit
                number = number + i;
            } else if (i == 'F' || i == 'L' || i == 'R') { // Checks if move is a valid move
                int multi;
                if (number.equals("")) {
                    multi = 1;
                } else {
                    multi = Integer.parseInt(number);
                }

                for (int j = 0; j < multi; j++) { // Repeats move by specified number, e.g 4F, adds F 4 times
                    expanded = expanded + i;
                }
                number = "";
            }
        }
        return expanded; // Return canonical path
    }
}
