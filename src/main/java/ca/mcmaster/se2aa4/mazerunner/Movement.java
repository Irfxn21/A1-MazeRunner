package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Movement extends User implements Move { // Class to determine movement

    private ArrayList<Character> path = new ArrayList<Character>(); // Array list to store moves in path
    private PathCalculator pathCalculator;

    public Movement(int row, int column) {
        super(row, column);
        this.pathCalculator = new PathCalculator(path); // Create new pbject in PathCalculator
    }

    public void turnRight() { // Method to turn right
        if (direction == 'N') {
            direction = 'E';
        } else if (direction == 'S') {
            direction = 'W';
        } else if (direction == 'E') {
            direction = 'S';
        } else {
            direction = 'N';
        }
        path.add('R');
    }

    public void turnLeft() { // Method to turn left
        if (direction == 'N') {
            direction = 'W';
        } else if (direction == 'S') {
            direction = 'E';
        } else if (direction == 'E') {
            direction = 'N';
        } else {
            direction = 'S';
        }
        path.add('L');
    }

    public void moveForward() { // Method to move forward
        if (direction == 'N') {
            row = row - 1;
            path.add('F');
        } else if (direction == 'S') {
            row = row + 1;
            path.add('F');
        } else if (direction == 'E') {
            column = column + 1;
            path.add('F');
        } else if (direction == 'W') {
            column = column - 1;
            path.add('F');
        }
    }

    public void displayPath() { // Method to display path
        pathCalculator.factorizedPath();
    }

}
