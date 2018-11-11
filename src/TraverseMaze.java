import java.util.HashSet;
import java.util.Set;

public class TraverseMaze {

    private int[][] moveUp = {{1, 0}};
    private int[][] moveDown = {{-1, 0}};
    private int[][] moveLeft = {{0, -1}};
    private int[][] moveRight = {{0, 1}};
    private String [][] maze;
    private int [][] startPos;
    private int [][] endPos;
    private Set<int [][]> alreadyVisited = new HashSet<>();
    private Set<int [][]> pathSoFar = new HashSet<>();


    public TraverseMaze(String[][] traverseMaze, int[][] startPos, int[][] endPos){
        this.maze = traverseMaze;
        this.startPos = startPos;
        this.endPos = endPos;

    }

    public int[][] moveLeft(int[][] currentPosition){
        int newPositionX = currentPosition[0][0] + moveLeft[0][0];
        int newPositionY = currentPosition[0][1] + moveLeft[0][1];
        int [][] newCurrentPosition = {{newPositionX, newPositionY}};
        System.out.println();
        return newCurrentPosition;
    }

    public int[][] moveRight(int[][] currentPosition){
        int newPositionX = currentPosition[0][0] + moveRight[0][0];
        int newPositionY = currentPosition[0][1] + moveRight[0][1];
        int [][] newCurrentPosition = {{newPositionX, newPositionY}};
        System.out.println();
        return newCurrentPosition;
    }

    public int[][] moveDown(int[][] currentPosition){
        int newPositionX = currentPosition[0][0]+ moveDown[0][0];
        int newPositionY = currentPosition[0][1]+ moveDown[0][1];
        int [][] newCurrentPosition = {{newPositionX, newPositionY}};
        System.out.println();
        return newCurrentPosition;

    }

    public int[][] moveUp(int[][] currentPosition){
        int newPositionX = currentPosition[0][0] + moveUp[0][0];
        int newPositionY = currentPosition[0][1] + moveUp[0][1];
        int [][] newCurrentPosition = {{newPositionX, newPositionY}};
        return newCurrentPosition;

    }

    public String move(int[][] initialPosition){
        alreadyVisited.add(initialPosition);
        int [][] newRightPosition = moveRight(initialPosition);
        int [][] newLeftPosition = moveLeft(initialPosition);
        int [][] newDownPosition = moveDown(initialPosition);
        int [][] newUpPosition = moveUp(initialPosition);
        if(!maze[newRightPosition[0][0]][newRightPosition[0][1]].equals("#") && !alreadyVisited.contains(newRightPosition) ){
            pathSoFar.add(newRightPosition);
            move(newRightPosition);
        }
        else if(!maze[newLeftPosition[0][0]][newLeftPosition[0][1]].equals("#") && !alreadyVisited.contains(newLeftPosition)){
            pathSoFar.add(newLeftPosition);
            move(newLeftPosition);
        }
        else if(!maze[newDownPosition[0][0]][newDownPosition[0][1]].equals("#") && !alreadyVisited.contains(newDownPosition) ){
            pathSoFar.add(newDownPosition);
            move(newDownPosition);
        }
        else if(!maze[newUpPosition[0][0]][newUpPosition[0][1]].equals("#") && !alreadyVisited.contains(newUpPosition)){
            pathSoFar.add(newUpPosition);
            move(newUpPosition);
        }
            return "FAILURE";
    }


}
