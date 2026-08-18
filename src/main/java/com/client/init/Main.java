package src.main.java.com.client.init;

import java.util.InputMismatchException;
import java.util.Scanner;

import src.main.java.com.client.ui.ClientMenu;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option = -1;
        ClientMenu clientMenu = new ClientMenu();

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
                    clientMenu.clientMenu();
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