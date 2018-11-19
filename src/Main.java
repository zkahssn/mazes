import java.util.*;

public class Main {

//this is the main class where the algorithm will be executed from.
    public static void main(String[] args) {
        ReadMaze rm = new ReadMaze();
        Scanner sc = new Scanner(System.in);
        String[][] maze;
        Set<String> keys = new HashSet<>();
        keys.add("#");
        keys.add("S");
        keys.add("F");

        System.out.println("Input the filename with the extention");
        rm.setFilePath(sc.nextLine());
        maze = rm.readMaze();
        TraverseMaze tm = new TraverseMaze(maze);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        //find the path
        tm.move(rm.getStartPos());
        for (int[][] node : tm.getPathStack()) {
            if (!keys.contains(maze[node[0][0]][node[0][1]])) {
                maze[node[0][0]][node[0][1]] = "X";
            }
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].equals("0")) {
                    maze[i][j] = " ";
                }
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

}
