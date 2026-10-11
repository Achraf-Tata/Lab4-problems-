package problem1;

import java.util.Scanner;

public class Sales {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter the number of salespeople : ");
        int SALESPEOPLE = scan.nextInt();
        int[] sales = new int[SALESPEOPLE];

        int sum = 0;
        int max = 0;
        int maxID = 0;
        int min = 0;
        int minID = 0;

        for (int i = 0; i < sales.length; i++) {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            sales[i] = scan.nextInt();
            sum += sales[i];

            if (i == 0 || sales[i] > max) {
                max = sales[i];
                maxID = i + 1;
            }
            if (i == 0 || sales[i] < min) {
                min = sales[i];
                minID = i + 1;
            }
        }

        System.out.println("\nSalesperson Sales");
        System.out.println("--------------------");
        for (int i = 0; i < sales.length; i++) {
            System.out.println(" " + (i + 1) + " " + sales[i]);
        }

        System.out.println("\nTotal sales: " + sum);
        System.out.println("Average sale: " + ((double) sum / SALESPEOPLE));
        System.out.println("Salesperson " + maxID + " is the highest with " + max + ".");
        System.out.println("Salesprrson " + minID + " s the lowest with " + min + ".");

        System.out.print("\nEnter a sales amount: ");
        int value = scan.nextInt();
        int count = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > value) {
                System.out.println("Salesperso, " + (i + 1) + " sold " + sales[i]);
                count++;
            }
        }
        System.out.println("Total number of salespeoples exceededing " + value + " : " + count);
        scan.close();
    }
}