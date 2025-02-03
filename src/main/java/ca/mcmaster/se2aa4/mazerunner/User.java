package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;
import java.util.ArrayList;

public class User {

    // Attributes
    private int row;
    private int column;
    private char direction = 'E'; // Initial direction set East for now
    private ArrayList<Character> path = new ArrayList<Character>(); // Array list to store moves in path

    public User(int row, int column) {
        this.row = row;
        this.column = column; // Constructors
    }

    public int getRow() {
        return row; // Get row of current postion
    }

    public int getColumn() {
        return column; // Get column of current postion
    }

    public int getNextRow() {
        if (direction == 'N') {
            return row - 1;
        }
        if (direction == 'S') {
            return row + 1;
        }
        return row;
    }

    public int getNextColumn() {
        if (direction == 'E') {
            return column + 1;
        }
        if (direction == 'W') {
            return column - 1;
        }
        return column;
    }

    public int getRightRow() {
        if (direction == 'N' || direction == 'S') {
            return row;
        }
        if (direction == 'E') {
            return row + 1;
        }
        return row - 1;
    }

    public int getRightColumn() {
        if (direction == 'E' || direction == 'W') {
            return column;
        }
        if (direction == 'N') {
            return column + 1;
        }
        return column - 1;
    }

    public void turnRight() {
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

    public void turnLeft() {
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

    public void moveForward() { // Method to move forward in the maze
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

    public void canonicalPath() { // Method to display canonical path
        System.out.println("Canonical Path: ");
        for (char i : path) { // Loop through each move in array list
            System.out.print(i); // Print each move
        }
        System.out.println();
    }

    public void factorizedPath() {
        char temp = path.get(0);
        int count = 1;
        System.out.println("Factorized Path: ");
        for (int i = 1; i < path.size(); i++) {
            if (path.get(i) == temp) {
                count += 1;
            } else {
                if (count > 1) {
                    System.out.print(count + "" + temp + " ");
                } else {
                    System.out.print(temp + " ");
                }
                count = 1;
                temp = path.get(i);
            }
        }
        if (count > 1) {
            System.out.print(count + "" + temp);
        } else {
            System.out.print(temp);
        }
        System.out.println();
    }
}