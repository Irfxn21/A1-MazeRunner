package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

public class PathCalculator { // Class to calculate path for maze

    private List<Character> path; // List to store moves

    public PathCalculator(List<Character> path) {
        this.path = path;
    }

    public void canonicalPath() { // Method to display canonical path
        System.out.println("Canonical Path: ");
        for (char i : path) { // Loop through each move in array list
            System.out.print(i); // Print each move
        }
        System.out.println();
    }

    public void factorizedPath() { // Method to calculate factorized path
        char temp = path.get(0); // Get first move from list of moves stored
        int count = 1;
        for (int i = 1; i < path.size(); i++) { // Iterate through list of moves
            if (path.get(i) == temp) { // Checks if move matches previously stored move
                count += 1;
            } else {
                if (count > 1) {
                    System.out.print(count + "" + temp + " ");
                } else {
                    System.out.print(temp + " "); // Prints out factorized path
                }
                count = 1;
                temp = path.get(i); // Resets variables
            }
        }
        if (count > 1) { // Prints out the last move
            System.out.print(count + "" + temp);
        } else {
            System.out.print(temp);
        }
        System.out.println();
    }
}
