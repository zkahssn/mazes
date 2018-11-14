import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        ReadMaze rm = new ReadMaze();
        Scanner sc = new Scanner(System.in);
        String[][] maze;
        Set<String> keys = new HashSet<>();
        keys.add("#");
        keys.add("S");
        keys.add("F");

        System.out.println("Please input ;the filename with the extention");
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
            Deque<int[][]> theFinalPath = tm.getPathStack();
            for(int[][] node: theFinalPath){
               if (!keys.contains(maze[node[0][0]][node[0][1]])) {
                    maze[node[0][0]][node[0][1]] = "X";
                }
            }
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    if(maze[i][j].equals("0")){
                       maze[i][j] = " ";
                    }
                        System.out.print(maze[i][j] + " ");
                }
                System.out.println();

            }
            System.out.println();
        }

    }

}
