package backtrack;

import java.util.*;
// This is a branch of master
public class Main {

//this is the main class where the algorithm will be executed from.
    public static void main(String[] args) {
        MazeReader rm = new MazeReader();
        Scanner sc = new Scanner(System.in);
        String[][] maze;
        System.out.println("Input the filename with the extension");
        rm.setFilePath(sc.nextLine());
        maze = rm.readMaze();
        MazeTraverser tm = new MazeTraverser(maze);
        //find the path
        boolean solved = tm.solveMaze(rm.getStartPos());
    }

}
