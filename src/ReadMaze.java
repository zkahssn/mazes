import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadMaze {
    private Path FilePath;
    private int startX = 0;
    private int startY = 0;
    private int endX= 0;
    private int endY=0;
    private String[][] inputMaze;
    public ReadMaze(){}

    public void setFilePath(String fileName){
        FilePath = Paths.get(fileName);
    }

    public Path getFilePath(){
     return FilePath;
    }

    public void readMaze(){
        try(LineNumberReader lr = new LineNumberReader(Files.newBufferedReader(((FilePath))))) {
            String line;
            int lineCount =0;
            while  ((line = lr.readLine()) != null) {
                int lineNumber = lr.getLineNumber();
                String[] currentLine = line.split(" ");
                if (lineNumber == 1) {
                    inputMaze = new String[Integer.parseInt(currentLine[0])][];
                }
                else if (lineNumber == 2) {
                    startX = Integer.parseInt(currentLine[0]);
                    startY = Integer.parseInt(currentLine[1]);
                }
                else if (lineNumber == 3) {
                    endX = Integer.parseInt(currentLine[0]);
                    endY = Integer.parseInt(currentLine[1]);
                }
                else{
                    for(int i =0; i < currentLine.length; i++){
                        if(currentLine[i].equals("1")){
                            inputMaze[lineCount][i] = "#";

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
        }

    }

    public String[][] getInputMaze(){
        return inputMaze;
    }


    public static void main(String[] args) {






    }

}
