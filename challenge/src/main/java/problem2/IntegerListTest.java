package problem2;

import java.util.Scanner;

public class IntegerListTest
{
    static IntegerList list = new IntegerList(10);
    static Scanner scan = new Scanner(System.in);

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

    public static void dispatch(int choice)
    {
        int value;
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
                list.print();
                break;
            case 3:
                System.out.println("Enter the value to add:");
                value = scan.nextInt();
                list.addElement(value);
                break;
            case 4:
                System.out.println("Enter the value to remove:");
                value = scan.nextInt();
                list.removeFirst(value);
                break;
            case 5:
                System.out.println("Enter the value to remove:");
                value = scan.nextInt();
                list.removeAll(value);
                break;
            default:
                System.out.println("Sorry, invalid choice");
        }
    }

    public static void printMenu()
    {
        System.out.println("\n Menu ");
        System.out.println(" ====");
        System.out.println("0: Quit");
        System.out.println("1: Create a new list (** do this first!! **)");
        System.out.println("2: Print the list");
        System.out.println("3: Add an element");
        System.out.println("4: Remove first occurrence");
        System.out.println("5: Remove all occurrences");
        System.out.print("\nEnter your choice: ");
    }
}