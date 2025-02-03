package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;
import java.util.ArrayList;

public class User {

    // Attributes
    private int row;
    private int column;
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

    public void moveForward() { // Method to move forward in the maze
        char direction = 'E'; // Initial direction set East for now
        switch (direction) { // Switch case to change position depending on direction faced
            case 'N':
                row = row - 1;
                path.add('F');
                break;
            case 'S':
                row = row + 1;
                path.add('F');
                break;
            case 'E':
                column = column + 1;
                path.add('F');
                break;
            case 'W':
                column = column - 1;
                path.add('F');
                break;
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