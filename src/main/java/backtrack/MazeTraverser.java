package backtrack;

import java.util.*;

public class MazeTraverser {

    private Directions directions = new Directions();
    private Position moveUp = directions.moveUp();
    private Position moveDown = directions.moveDown();
    private Position moveLeft = directions.moveLeft();
    private Position moveRight = directions.moveRight();
    private String[][] maze;
    Set<String> keys = new HashSet<>();
    private Set<Position> alreadyVisited = new HashSet<>();
    private Deque<Position> thePathStack = new ArrayDeque<>();
    private MazeReader mr = new MazeReader();

    public MazeTraverser(String[][] traverseMaze) {
        this.maze = traverseMaze;
        keys.add("#");
        keys.add("S");
        keys.add("E");
    }

    public Position moveLeft(Position currentPosition) {
        int newPositionY = currentPosition.getY() + moveLeft.getY();
        int newPositionX = currentPosition.getX() + moveLeft.getX();
        return new Position(newPositionY, newPositionX);
    }

    public Position moveRight(Position currentPosition) {
        int newPositionY = currentPosition.getY() + moveRight.getY();
        int newPositionX = currentPosition.getX() + moveRight.getX();
        return new Position(newPositionY, newPositionX);
    }

    public Position moveDown(Position currentPosition) {
        int newPositionY = currentPosition.getY() + moveDown.getY();
        int newPositionX = currentPosition.getX() + moveDown.getX();
        return new Position(newPositionY, newPositionX);

    }

    public Position moveUp(Position currentPosition) {
        int newPositionY = currentPosition.getY() + moveUp.getY();
        int newPositionX = currentPosition.getX() + moveUp.getX();
        return new Position(newPositionY, newPositionX);

    }

    public boolean solveMaze(Position initialPosition) {
        int X = initialPosition.getX();
        int Y = initialPosition.getY();
        if (maze[Y][X].equals("S")) {
            //first in
            thePathStack.add(initialPosition);
        }
        if (maze[Y][X].equals("E")) {
            for (Position node : getPathStack()) {
                if (!keys.contains(maze[node.getY()][node.getX()])) {
                    maze[node.getY()][node.getX()] = "X";
                }
            }
            mr.printMaze(maze);
            return true;
        }
        Position newRightPosition = moveRight(initialPosition);
        Position newLeftPosition = moveLeft(initialPosition);
        Position newDownPosition = moveDown(initialPosition);
        Position newUpPosition = moveUp(initialPosition);

        if (!maze[newRightPosition.getY()][newRightPosition.getX()].equals("#") && !isOnStack(newRightPosition) && !isAlreadyVisted(newRightPosition)) {
            thePathStack.add(initialPosition);
            solveMaze(newRightPosition);
        } else if (!maze[newDownPosition.getY()][newDownPosition.getX()].equals("#") && !isOnStack(newDownPosition) && !isAlreadyVisted(newDownPosition)) {
            thePathStack.add(initialPosition);
            solveMaze(newDownPosition);
        } else if (!maze[newLeftPosition.getY()][newLeftPosition.getX()].equals("#") && !isOnStack(newLeftPosition) && !isAlreadyVisted(newLeftPosition)) {
            thePathStack.add(initialPosition);
            solveMaze(newLeftPosition);
        } else if (!maze[newUpPosition.getY()][newUpPosition.getX()].equals("#") && !isOnStack(newUpPosition) && !isAlreadyVisted(newUpPosition)) {
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

    public boolean isAlreadyVisted(Position currentPosition) {
        for (Position node : alreadyVisited) {
            if (node.getY() == currentPosition.getY() && node.getX() == currentPosition.getX()) {
                return true;
            }
        }
        return false;
    }


    public Deque<Position> getPathStack() {
        return thePathStack;
    }

    public boolean isOnStack(Position currentPosition) {
        for (Position node : thePathStack) {
            if (node.getY() == currentPosition.getY() && node.getX() == currentPosition.getX()) {
                return true;
            }
        }
        return false;
    }
}
