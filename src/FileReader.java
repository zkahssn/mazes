import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FileReader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter full path of input");
        String FileName = sc.nextLine();
        String[][] inputMax;
        System.out.println(FileName);

        try(BufferedReader br = Files.newBufferedReader(Paths.get(FileName))) {
            br.lines().forEach(line -> {
                System.out.println(line);
            });

        } catch (Exception e) {

        }
    }

}
