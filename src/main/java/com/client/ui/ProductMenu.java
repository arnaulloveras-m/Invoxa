package src.main.java.com.client.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductMenu {

    private Scanner sc = new Scanner(System.in);
    private int option = -1;

    public void clientMenu() {
        System.out.println("====== PRODUCTS ======");
        System.out.println("1.Create product");
        System.out.println("2.List products");
        System.out.println("3.Find product by ID");
        System.out.println("4.Edit product");
        System.out.println("5.Delete product");
        System.out.println();
        System.out.print("Choose an option: ");
        
        try {
            option = sc.nextInt();
            System.out.println();
        } catch(InputMismatchException e) {
            System.out.println(e);
            System.out.println("Input a valid option: ");
            sc.nextLine(); // Consume the incorrect answer
        }

    }
    
}
