package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;
import java.util.ArrayList;

public class User {

    private int row;
    private int column;
    private ArrayList<Character> path = new ArrayList<Character>();

    public User(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void moveForward() {
        char direction = 'E';
        switch (direction) {
            case 'N':
                row = row-1;
                path.add('F');
                break;
            case 'S':
                row = row+1;
                path.add('F');
                break;
            case 'E':
                column = column+1;
                path.add('F');
                break;
            case 'W':
                column = column-1;
                path.add('F');
                break;
        }
    }

    public void canonicalPath() {
        System.out.println("Canonical Path: ");
        for (char i : path) {
            System.out.print(i);
        }
        System.out.println();
    }
}