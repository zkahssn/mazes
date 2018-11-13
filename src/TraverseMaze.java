import java.util.HashSet;
import java.util.Optional;
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
        if(maze[initialPosition[0][0]][initialPosition[0][1]].equals("F") ){
            pathSoFar.add(initialPosition);
            return "success";
        }
        int [][] newRightPosition = moveRight(initialPosition);
        int [][] newLeftPosition = moveLeft(initialPosition);
        int [][] newDownPosition = moveDown(initialPosition);
        int [][] newUpPosition = moveUp(initialPosition);
        if(!maze[newRightPosition[0][0]][newRightPosition[0][1]].equals("#") && !isAlreadyVisted(newRightPosition) ){
            pathSoFar.add(newRightPosition);
            alreadyVisited.add(newLeftPosition);
            alreadyVisited.add(newDownPosition);
            alreadyVisited.add(newUpPosition);
            move(newRightPosition);
        }
        else if(!maze[newDownPosition[0][0]][newDownPosition[0][1]].equals("#") && !isAlreadyVisted(newDownPosition) ){
            pathSoFar.add(newDownPosition);
            alreadyVisited.add(newRightPosition);
            alreadyVisited.add(newLeftPosition);
            alreadyVisited.add(newUpPosition);
            move(newDownPosition);
        }
        else if(!maze[newLeftPosition[0][0]][newLeftPosition[0][1]].equals("#") && !isAlreadyVisted(newLeftPosition)){
            pathSoFar.add(newLeftPosition);
            alreadyVisited.add(newRightPosition);
            alreadyVisited.add(newDownPosition);
            alreadyVisited.add(newUpPosition);
            isAlreadyVisted(newLeftPosition);
            move(newLeftPosition);
        }
        else if(!maze[newUpPosition[0][0]][newUpPosition[0][1]].equals("#") && !isAlreadyVisted(newUpPosition)){
            pathSoFar.add(newUpPosition);
            alreadyVisited.add(newRightPosition);
            alreadyVisited.add(newLeftPosition);
            alreadyVisited.add(newDownPosition);
            move(newUpPosition);
        }
        else{
            //at dead end, need to backtrack
            System.out.println();
        }
            return "FAILURE";
    }

    public boolean isAlreadyVisted(int [][] currentPosition){
        alreadyVisited.stream().findAny().filter(val -> val[0][0] == currentPosition[0][0] && val[0][1] == currentPosition[0][1]);
        for(int[][] node: alreadyVisited){
            if(node[0][0] == currentPosition[0][0] && node[0][1] == currentPosition[0][1]){
                return true;
            }
            System.out.println();
        }
        return false;
    }

    public Set<int[][]> getFinalPath(){
        return pathSoFar;
    }

}
