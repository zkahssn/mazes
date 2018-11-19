import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadMaze {
    private Path FilePath;
    private int [][] startPos = {{0,0}};
    private int [][] endPos = {{0,0}};
    private String[][] inputMaze;
    public ReadMaze(){}

    public void setFilePath(String fileName){
        FilePath = Paths.get(fileName);
    }

    public String [][] readMaze(){
        try(LineNumberReader lr = new LineNumberReader(Files.newBufferedReader(((FilePath))))) {
            String line;
            int lineCount =0;
            while  ((line = lr.readLine()) != null) {
                int lineNumber = lr.getLineNumber();
                String[] currentLine = line.split(" ");
                if (lineNumber == 1) {
                    inputMaze = new String[Integer.parseInt(currentLine[1])][];
                    for(int i = 0; i< inputMaze.length; i++){
                        inputMaze[i] = new String[Integer.parseInt(currentLine[0])];
                    }
                }
                else if (lineNumber == 2) {
                    startPos[0][0] = Integer.parseInt(currentLine[1]);
                    startPos[0][1] = Integer.parseInt(currentLine[0]);
                }
                else if (lineNumber == 3) {
                    endPos[0][0] = Integer.parseInt(currentLine[1]);
                    endPos[0][1] = Integer.parseInt(currentLine[0]);
                }
                else{
                    for(int i =0; i < currentLine.length; i++){
                        if(currentLine[i].equals("1")){
                            inputMaze[lineCount][i] = "#";
                        }
                        else if(lineCount == startPos[0][0] && i== startPos[0][1]){
                            inputMaze[lineCount][i] = "S";
                        }
                        else if(lineCount == endPos[0][0] && i == endPos[0][1]){
                            inputMaze[lineCount][i] = "E";
                        }
                        else {
                            inputMaze[lineCount][i] = currentLine[i];
                        }
                    }
                    lineCount++;
                }
            }
            lr.close();
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
        return inputMaze;
    }


    public int[][] getStartPos(){
        return startPos;
    }
    public int[][] getEndPos(){
        return endPos;
    }


}
