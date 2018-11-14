import java.util.Deque;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        ReadMaze rm = new ReadMaze();
        Scanner sc = new Scanner(System.in);
        int[][] moveUp = {{0, 1}};
        int[][] moveDown = {{1, 0}};
        int[][] moveLeft = {{-1, 0}};
        int[][] moveRight = {{1, 0}};
        String[][] maze;
        System.out.println("Please input the filename with the extention");
        rm.setFilePath(sc.nextLine());
        if (rm.getFilePath() != null) {
            rm.readMaze();
            maze = rm.getInputMaze();
            TraverseMaze tm = new TraverseMaze(maze, rm.getStartPos(), rm.getEndPos());
            System.out.println();
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    System.out.print(maze[i][j] + " ");
                }
                System.out.println();

            }
            tm.move(rm.getStartPos());
            Deque<int[][]> theFinalPath = tm.getPathSoStack();
            for(int[][] node: theFinalPath){
                maze[node[0][0]][node[0][1]] = "*";
            }
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    System.out.print(maze[i][j] + " ");
                }
                System.out.println();

            }
            System.out.println();
        }

    }

}
