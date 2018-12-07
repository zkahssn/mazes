package backtrack;

import java.util.*;

public class MazeTraverser {

    private int[][] moveUp = {{1, 0}};
    private int[][] moveDown = {{-1, 0}};
    private int[][] moveLeft = {{0, -1}};
    private int[][] moveRight = {{0, 1}};
    private String[][] maze;
    Set<String> keys = new HashSet<>();
    private Set<int[][]> alreadyVisited = new HashSet<>();
    private Deque<int[][]> thePathStack = new ArrayDeque<>();
    private MazeReader mr = new MazeReader();
    public MazeTraverser(String[][] traverseMaze) {
        this.maze = traverseMaze;
        keys.add("#");
        keys.add("S");
        keys.add("F");
    }

    public int[][] moveLeft(int[][] currentPosition) {
        int newPositionX = currentPosition[0][0] + moveLeft[0][0];
        int newPositionY = currentPosition[0][1] + moveLeft[0][1];
        int[][] newCurrentPosition = {{newPositionX, newPositionY}};
        return newCurrentPosition;
    }

    public int[][] moveRight(int[][] currentPosition) {
        int newPositionX = currentPosition[0][0] + moveRight[0][0];
        int newPositionY = currentPosition[0][1] + moveRight[0][1];
        int[][] newCurrentPosition = {{newPositionX, newPositionY}};
        return newCurrentPosition;
    }

    public int[][] moveDown(int[][] currentPosition) {
        int newPositionX = currentPosition[0][0] + moveDown[0][0];
        int newPositionY = currentPosition[0][1] + moveDown[0][1];
        int[][] newCurrentPosition = {{newPositionX, newPositionY}};
        return newCurrentPosition;

    }

    public int[][] moveUp(int[][] currentPosition) {
        int newPositionX = currentPosition[0][0] + moveUp[0][0];
        int newPositionY = currentPosition[0][1] + moveUp[0][1];
        int[][] newCurrentPosition = {{newPositionX, newPositionY}};
        return newCurrentPosition;

    }

    public boolean solveMaze(int[][] initialPosition) {
        if (maze[initialPosition[0][0]][initialPosition[0][1]].equals("S")) {
            //first in
            thePathStack.add(initialPosition);
        }
        if (maze[initialPosition[0][0]][initialPosition[0][1]].equals("E")) {
            for (int[][] node : getPathStack()) {
                if (!keys.contains(maze[node[0][0]][node[0][1]])) {
                    maze[node[0][0]][node[0][1]] = "X";
                }
            }
            mr.printMaze(maze);
            return true;
        }
        int[][] newRightPosition = moveRight(initialPosition);
        int[][] newLeftPosition = moveLeft(initialPosition);
        int[][] newDownPosition = moveDown(initialPosition);
        int[][] newUpPosition = moveUp(initialPosition);

        if (!maze[newRightPosition[0][0]][newRightPosition[0][1]].equals("#") && !isOnStack(newRightPosition) && !isAlreadyVisted(newRightPosition)) {
            thePathStack.add(initialPosition);
            solveMaze(newRightPosition);
        } else if (!maze[newDownPosition[0][0]][newDownPosition[0][1]].equals("#") && !isOnStack(newDownPosition) && !isAlreadyVisted(newDownPosition)) {
            thePathStack.add(initialPosition);
            solveMaze(newDownPosition);
        } else if (!maze[newLeftPosition[0][0]][newLeftPosition[0][1]].equals("#") && !isOnStack(newLeftPosition) && !isAlreadyVisted(newLeftPosition)) {
            thePathStack.add(initialPosition);
            solveMaze(newLeftPosition);
        } else if (!maze[newUpPosition[0][0]][newUpPosition[0][1]].equals("#") && !isOnStack(newUpPosition) && !isAlreadyVisted(newUpPosition)) {
            thePathStack.add(initialPosition);
            solveMaze(newUpPosition);
        } else {
            //this is a dead end
            alreadyVisited.add(initialPosition);
            //backtrack
            solveMaze(thePathStack.removeLast());
        }
        return false;
    }

    public boolean isAlreadyVisted(int[][] currentPosition) {
        for (int[][] node : alreadyVisited) {
            if (node[0][0] == currentPosition[0][0] && node[0][1] == currentPosition[0][1]) {
                return true;
            }
        }
        return false;
    }


    public Deque<int[][]> getPathStack() {
        return thePathStack;
    }

    public boolean isOnStack(int[][] currentPosition) {
        for (int[][] node : thePathStack) {
            if (node[0][0] == currentPosition[0][0] && node[0][1] == currentPosition[0][1]) {
                return true;
            }
        }
        return false;
    }
}
