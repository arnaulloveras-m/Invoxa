package src.main.java.com.client.ui;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.main.java.com.client.services.ProductService;

public class ProductMenu {

    private Scanner sc = new Scanner(System.in);
    private int option = -1;
    private ProductService productService = new ProductService();

    public void productMenu() {
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
            sc.nextLine(); //Consuming the line
            System.out.println();
        } catch(InputMismatchException e) {
            System.out.println(e);
            System.out.println("Input a valid option: ");
            sc.nextLine(); // Consume the incorrect answer
        }

        switch (option) {
            case 1:
                createProduct();
                break;

            case 2:
                
                break;

            case 3:
                
                break;

            case 4:
                
                break;

            case 5:
                
                break;
        
            default:
                break;
        }

    }

    private void createProduct() {
        System.out.println("Name of the new product: ");
        String name = sc.nextLine();
        System.out.println("Description of the product: ");
        String description = sc.nextLine();
        System.out.println("Price of the product: ");
        BigDecimal price = sc.nextBigDecimal();
        System.out.println("What tax does it have: ");
        BigDecimal tax = sc.nextBigDecimal();
        productService.createProduct(name, description, price, tax);
    }
    
}
