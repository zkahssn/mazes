import java.util.Scanner;
public class Main {


    public static void main(String [] args){
        ReadMaze rm = new ReadMaze();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the filename with the extention");
        rm.setFilePath(sc.nextLine());
        if(rm.getFilePath() != null){
            rm.readMaze();
            String [][] maze = rm.getInputMaze();
            System.out.println();
        }

    }

}
