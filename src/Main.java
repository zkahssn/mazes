import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ReadMaze rm = new ReadMaze();
        Scanner sc = new Scanner(System.in);
        int[][] moveUp = {{0, 1}};
        int[][] moveDown = {{1, 0}};
        int[][] moveLeft = {{-1, 0}};
        int[][] moveRight = {{1, 0}};
        System.out.println("Please input the filename with the extention");
        rm.setFilePath(sc.nextLine());
        if (rm.getFilePath() != null) {
            rm.readMaze();
            String[][] maze = rm.getInputMaze();
            TraverseMaze tm = new TraverseMaze(maze, rm.getStartPos(), rm.getEndPos());
            System.out.println();
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    System.out.print(maze[i][j] + " ");
                }
                System.out.println();

            }
            tm.move(rm.getStartPos());
        }

    }

}
