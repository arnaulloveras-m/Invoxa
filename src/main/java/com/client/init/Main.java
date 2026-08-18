package src.main.java.com.client.init;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {

            System.out.println("======= INVOXA =======");
            System.out.println("1.Clients");
            System.out.println("2.Products");
            System.out.println("3.Invoices");
            System.out.println("0.Exit");
            System.out.println("Choose an option: ");

            try {
                option = sc.nextInt();
            } catch(InputMismatchException e) {
                System.out.println(e);
                System.out.println("Input a valid option: ");
                sc.nextLine(); // Consume the incorrect answer
                continue;
            }

            switch (option) {
                case 1:
                    
                    break;
                
                case 2:

                    break;
                    
                case 3:

                    break;

                case 0:
                    
                    System.out.println("Closing...");
                    break;

                default:
                    System.out.println("Invalid number");
                    break;
            }
        }
    }
}