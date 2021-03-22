// **************************************************************** 
// IntegerListTest.java 
// 
// Provide a menu-driven tester for the IntegerList class. 
// 
// **************************************************************** 
import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 

public class IntegerListTest 
{ 
    static IntegerList list = new IntegerList(10); 
    static Scanner scan = new Scanner(System.in); 
    
    //------------------------------------------------------- 
    // Create a list, then repeatedly print the menu and do what the 
    // user asks until they quit 
    //------------------------------------------------------- 
    public static void main(String[] args) 
    { 
        printMenu(); 
        int choice = scan.nextInt(); 
        while (choice != 0) 
        { 
            dispatch(choice); 
            printMenu(); 
            choice = scan.nextInt(); 
        } 
    } 
    
    //------------------------------------------------------- 
    // Do what the menu item calls for 
    //------------------------------------------------------- 
    public static void dispatch(int choice) 
    { 
        int loc; 
        int oldVal, newVal;

        switch(choice) 
        { 
            case 0: 
                System.out.println("Bye!"); 
                break; 
            case 1: 
                System.out.println("How big should the list be?"); 
                int size = scan.nextInt(); 
                list = new IntegerList(size); 
                list.randomize(); 
                break; 
            case 2: 
                list.selectionSortIncrease(); 
                break; 
            case 3: 
                list.selectionSortDecrease(); 
                break; 
            case 4: 
                System.out.print("Enter the value to look for: "); 
                loc = list.search(scan.nextInt()); 
                if (loc != -1) 
                    System.out.println("Found at location " + loc); 
                else 
                    System.out.println("Not in list"); 
                break; 
            case 5: 
                list.print(); 
                break; 
            case 6:
                Scanner scan1 = new Scanner(System.in); 
                Scanner scan2 = new Scanner(System.in);

                System.out.println("Insert value that you want to change: ");
                oldVal = scan1.nextInt();
                System.out.println("Insert value replacement: ");
                newVal = scan1.nextInt();

                list.replaceFirst(oldVal, newVal);
                break;
            case 7:
                Scanner scan3 = new Scanner(System.in); 
                Scanner scan4 = new Scanner(System.in);
                int oldValue, newValue;

                System.out.println("Insert value that you want to change: ");
                oldVal = scan3.nextInt();
                System.out.println("Insert value replacement: ");
                newVal = scan4.nextInt();

                list.replaceAll(oldVal, newVal);
                break;
            case 8:
                System.out.print("Enter the value to look for: "); 
                loc = list.binarySearchD(scan.nextInt()); 
                if (loc != -1) 
                    System.out.println("Found at location " + loc); 
                else 
                    System.out.println("Not in list"); 
                break; 
            default: 
                System.out.println("Sorry, invalid choice"); 
        } 
    } 
    
    //------------------------------------------------------- 
    // Print the user's choices 
    //------------------------------------------------------- 
    public static void printMenu() 
    { 
        System.out.println("\n Menu "); 
        System.out.println(" ===="); 
        System.out.println("0: Quit"); 
        System.out.println("1: Create a new list (** do this first!! **)"); 
        System.out.println("2: Sort the list using selection sort in increasing order"); 
        System.out.println("3: Sort the list using selection sort in decreasing order"); 
        System.out.println("4: Find an element in the list using linear search"); 
        System.out.println("5: Print the list"); 
        System.out.println("6: Change Value (only the first similar value will be changed)"); 
        System.out.println("7: Change Value (all similar value will be changed)"); 
        System.out.println("8: Find an element in the list using binary search"); 
        System.out.print("\nEnter your choice: "); 
    } 
}
