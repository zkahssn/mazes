import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter full path of input");
        String FileName = sc.nextLine();
        String[][] inputMax;
        int startX = 0;
        int startY = 0;
        int endX =0;
        int endY =0;
        System.out.println(FileName);





        try(LineNumberReader lr = new LineNumberReader(Files.newBufferedReader((Paths.get(FileName))))) {
            String line;
            while  ((line = lr.readLine()) != null) {
                    int lineNumber = lr.getLineNumber();
                    if (lineNumber == 1) {
                        inputMax = new String[Integer.parseInt(line.split(" ")[0])][Integer.parseInt(line.split(" ")[1])];
                    }
                    if (lineNumber == 2) {
                        startX = Integer.parseInt(line.split(" ")[0]);
                        startY = Integer.parseInt(line.split(" ")[1]);
                    }
                    if (lineNumber == 3) {
                        endX = Integer.parseInt(line.split(" ")[0]);
                        endY = Integer.parseInt(line.split(" ")[1]);
                    } else {
                        System.out.println(line);
                    }

            }
        lr.close();
        } catch (IOException e) {

        }
        System.out.println();
    }

}
