package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker {

    private Maze maze;
    private Movement user;

    public PathChecker(Maze maze, Movement user) {
        this.maze = maze;
        this.user = user;
    }

    public boolean verifyPath(String path) {
        String canonicalPath = expandPath(path);
        for (char i : canonicalPath.toCharArray()) {
            if (i == 'F') {
                int nextRow = user.getNextRow();
                int nextColumn = user.getNextColumn();

                if (maze.wallCheck(nextRow, nextColumn)) {
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

        if (user.getColumn() == maze.sizeColumn() - 1) {
            System.out.println("Correct Path");
            return true;
        } else {
            System.out.println("Incorrect Path");
            return false;
        }
    }

    private String expandPath(String path) {

        String expanded = "";
        String number = "";

        for (char i : path.toCharArray()) {
            if (Character.isDigit(i)) {
                number = number + i;
            } else if (i == 'F' || i == 'L' || i == 'R') {
                int multi;
                if (number.equals("")) {
                    multi = 1;
                } else {
                    multi = Integer.parseInt(number);
                }

                for (int j = 0; j < multi; j++) {
                    expanded = expanded + i;
                }
                number = "";
            }
        }
        return expanded;
    }
}
