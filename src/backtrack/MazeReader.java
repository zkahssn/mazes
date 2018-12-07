package backtrack;

import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MazeReader {
    private Path filePath;
    private int [][] startPos = {{0,0}};
    private int [][] endPos = {{0,0}};
    private String[][] inputMaze;
    private Position startPosition;
    private Position endPosition;

    public MazeReader(){}

    public void setFilePath(String fileName){
        filePath = Paths.get(fileName);
    }

    public String [][] readMaze(){
        try(LineNumberReader lr = new LineNumberReader(Files.newBufferedReader(((filePath))))) {
            String line;
            int lineCount =0;
            while  ((line = lr.readLine()) != null) {
                int lineNumber = lr.getLineNumber();
                String[] currentLine = line.split(" ");
                if (lineNumber == 1) {
                    int width = Integer.parseInt(currentLine[0]);
                    int height = Integer.parseInt(currentLine[1]);
                    inputMaze = new String[height][width];
                }
                else if (lineNumber == 2) {
                    startPosition = new Position(Integer.parseInt(currentLine[1]), Integer.parseInt(currentLine[0]));
                }
                else if (lineNumber == 3) {
                    endPosition = new Position(Integer.parseInt(currentLine[1]), Integer.parseInt(currentLine[0]));
                }
                else{
                    for(int i =0; i < currentLine.length; i++){
                        if(currentLine[i].equals("1")){
                            inputMaze[lineCount][i] = "#";
                        }
                        else if(lineCount == startPosition.getY() && i== startPosition.getX()){
                            inputMaze[lineCount][i] = "S";
                        }
                        else if(lineCount == endPosition.getY() && i== endPosition.getX()){
                            inputMaze[lineCount][i] = "E";
                        }
                        else {
                            inputMaze[lineCount][i] = currentLine[i];
                        }
                    }
                    lineCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
        return inputMaze;
    }

    public void printMaze (String[][] printedMaze){
        for (int i = 0; i < printedMaze.length; i++) {
            for (int j = 0; j < printedMaze[i].length; j++) {
                System.out.print(printedMaze[i][j] + " ");
            }
            System.out.println();
        }
    }
    public Position getStartPos(){
        return startPosition;
    }
    public Position getEndPos(){
        return endPosition;
    }


}
