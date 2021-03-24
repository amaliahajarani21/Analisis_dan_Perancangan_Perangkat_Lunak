import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mainCopy {
    public static void main(String[] args) {
        boolean found = false;
        File file = new File("test1.txt");

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                int i = sc.nextInt();
                System.out.println(i);
            }
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}