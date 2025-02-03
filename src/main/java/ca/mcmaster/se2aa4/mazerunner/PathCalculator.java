package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

public class PathCalculator {

    private List<Character> path;

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
