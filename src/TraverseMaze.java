import java.util.*;

public class TraverseMaze {

    private int[][] moveUp = {{1, 0}};
    private int[][] moveDown = {{-1, 0}};
    private int[][] moveLeft = {{0, -1}};
    private int[][] moveRight = {{0, 1}};
    private String[][] maze;
    private Set<int[][]> alreadyVisited = new HashSet<>();
    private Deque<int[][]> thePathStack = new ArrayDeque<>();

    public TraverseMaze(String[][] traverseMaze) {
        this.maze = traverseMaze;
    }

    public int[][] moveLeft(int[][] currentPosition) {
        int newPositionX = currentPosition[0][0] + moveLeft[0][0];
        int newPositionY = currentPosition[0][1] + moveLeft[0][1];
        int[][] newCurrentPosition = {{newPositionX, newPositionY}};
        System.out.println();
        return newCurrentPosition;
    }

    public int[][] moveRight(int[][] currentPosition) {
        int newPositionX = currentPosition[0][0] + moveRight[0][0];
        int newPositionY = currentPosition[0][1] + moveRight[0][1];
        int[][] newCurrentPosition = {{newPositionX, newPositionY}};
        System.out.println();
        return newCurrentPosition;
    }

    public int[][] moveDown(int[][] currentPosition) {
        int newPositionX = currentPosition[0][0] + moveDown[0][0];
        int newPositionY = currentPosition[0][1] + moveDown[0][1];
        int[][] newCurrentPosition = {{newPositionX, newPositionY}};
        System.out.println();
        return newCurrentPosition;

    }

    public int[][] moveUp(int[][] currentPosition) {
        int newPositionX = currentPosition[0][0] + moveUp[0][0];
        int newPositionY = currentPosition[0][1] + moveUp[0][1];
        int[][] newCurrentPosition = {{newPositionX, newPositionY}};
        return newCurrentPosition;

    }

    public String move(int[][] initialPosition) {
        if (maze[initialPosition[0][0]][initialPosition[0][1]].equals("S")) {
            //first in
            thePathStack.add(initialPosition);
        }
        if (maze[initialPosition[0][0]][initialPosition[0][1]].equals("E")) {
            return "success";
        }
        int[][] newRightPosition = moveRight(initialPosition);
        int[][] newLeftPosition = moveLeft(initialPosition);
        int[][] newDownPosition = moveDown(initialPosition);
        int[][] newUpPosition = moveUp(initialPosition);

        if (!maze[newRightPosition[0][0]][newRightPosition[0][1]].equals("#") && !isOnStack(newRightPosition) && !isAlreadyVisted(newRightPosition)) {
            thePathStack.add(initialPosition);
            move(newRightPosition);
        } else if (!maze[newDownPosition[0][0]][newDownPosition[0][1]].equals("#") && !isOnStack(newDownPosition) && !isAlreadyVisted(newDownPosition)) {
            thePathStack.add(initialPosition);
            move(newDownPosition);
        } else if (!maze[newLeftPosition[0][0]][newLeftPosition[0][1]].equals("#") && !isOnStack(newLeftPosition) && !isAlreadyVisted(newLeftPosition)) {
            thePathStack.add(initialPosition);
            move(newLeftPosition);
        } else if (!maze[newUpPosition[0][0]][newUpPosition[0][1]].equals("#") && !isOnStack(newUpPosition) && !isAlreadyVisted(newUpPosition)) {
            thePathStack.add(initialPosition);
            move(newUpPosition);
        } else {
            //this is a dead end
            alreadyVisited.add(initialPosition);
            //backtrack
            move(thePathStack.removeLast());
        }
        return "FAILURE";
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
