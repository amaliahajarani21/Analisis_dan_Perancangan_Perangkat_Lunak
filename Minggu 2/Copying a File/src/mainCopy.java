import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class mainCopy {
    public static void main(String[] args) {
        boolean found = false;

        while (found == false){
            try {
                System.out.print("Enter the file name with extension : ");
    
                Scanner input = new Scanner(System.in);
    
                File file = new File(input.nextLine());
    
                input = new Scanner(file);
    
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    System.out.println(line);
                }
                input.close();
                found = true;
    
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
                System.out.println("Insert Another file please");
            }
        }
    }
}