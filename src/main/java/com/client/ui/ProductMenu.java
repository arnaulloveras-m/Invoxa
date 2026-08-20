package src.main.java.com.client.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.main.java.com.client.model.Client;
import src.main.java.com.client.model.Product;
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
                getAllProducts();
                break;

            case 3:
                findProductById();
                break;

            case 4:
                editProduct();
                break;

            case 5:
                deleteProduct();
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

    private void getAllProducts() {
        ArrayList<Product> products = productService.getAllProducts();
    
        for (Product product: products) {
            System.out.println(product);
        }
    }

    private void findProductById() {
        int id;
        do {
            System.out.println("What id you want to search: ");
            id = sc.nextInt();
        } while (id < 1);

        Product product = productService.findProductById(id);

        if (product == null) {
            System.out.println("There's no product with that id");
        } else {
            System.out.println(product);
        }
    }

    private void editProduct() {
        getAllProducts();
        
        int id;
        do {
            System.out.println("What id you want to edit: ");
            id = sc.nextInt();
        } while (id < 1);

        Product product = productService.findProductById(id);
        if (product == null) {
            System.out.println("There's no product with that id");
            return;
        }

        int parameter;
        System.out.println("[1].Name");
        System.out.println("[2].Description");
        System.out.println("[3].Price");
        System.out.println("[4].Tax");
        do {
            System.out.println("What parameter you want to change: ");
            parameter = sc.nextInt();
            sc.nextLine(); //Consuming last scanner
        } while (parameter < 1 || parameter > 4);

        switch (parameter) {
            case 1:
                System.out.println("Actual name: " + product.getName());
                System.out.println("New name: " );
                String newName = sc.nextLine();
                product.setName(newName);
                productService.saveProducts();
                break;

            case 2:
                System.out.println("Actual Description: " + product.getDescription());
                System.out.println("New Description: " );
                String newDescription = sc.nextLine();
                product.setDescription(newDescription);
                productService.saveProducts();
                break;

            case 3:
                System.out.println("Actual price: " + product.getPrice());
                System.out.println("New price: " );
                BigDecimal newPrice = sc.nextBigDecimal();
                product.setPrice(newPrice);
                productService.saveProducts();
                break;

            case 4:
                System.out.println("Actual tax: " + product.getTax());
                System.out.println("New tax: " );
                BigDecimal newTax = sc.nextBigDecimal();
                product.setTax(newTax);
                productService.saveProducts();
                break;      
        
            default:
                break;
        }
    }

    private void deleteProduct() {
        getAllProducts();
        
        int id;
        do {
            System.out.println("What id you want to delete: ");
            id = sc.nextInt();
        } while (id < 1);

        if (productService.deleteProduct(id)) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("That product doesn't exist.");
        }
    }
    
}
