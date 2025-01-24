package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class User {

    private int row;
    private int column;
    private ArrayList<Character> path = new ArrayList<Character>();
    private Maze maze = new Maze();

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
        switch (direction) {
            case 'N':
                row = row-1;
            case 'S':
                row = row+1;
            case 'E':
                column = column+1;
            case 'W':
                column = column-1
        }
        path.add('F')
    }

}