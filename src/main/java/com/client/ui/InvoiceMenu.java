package src.main.java.com.client.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.main.java.com.client.model.Client;
import src.main.java.com.client.model.Invoice;
import src.main.java.com.client.model.InvoiceLine;
import src.main.java.com.client.model.Product;
import src.main.java.com.client.services.ClientService;
import src.main.java.com.client.services.InvoiceService;
import src.main.java.com.client.services.ProductService;

public class InvoiceMenu {
    
    private Scanner sc = new Scanner(System.in);
    private int option = -1;
    private ClientService clientService = new ClientService();
    private ProductService productService = new ProductService();
    private InvoiceService invoiceService = new InvoiceService();
        
    public void invoiceMenu() {
        System.out.println("====== INVOICE ======");
        System.out.println("1.Create invoice");
        System.out.println("2.List invoices");
        System.out.println("3.Find invoice");
        System.out.println("4.Delete invoice");
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

        switch (option) {
            case 1:
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
                System.out.println("Invalid number");
                break;
        }
        
    }

    private void createInvoice() {
        boolean create = false;

        clientService.getAllClients();

        int id;
        do {
            System.out.println("Select client:");
            id = sc.nextInt();
        } while (id < 1);

        Client client = clientService.findClientById(id);
        if (client == null) {
            System.out.println("There's no client with that id");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Date(dd/MM/yyyy): ");
        String dateInput = sc.nextLine();

        LocalDate date = LocalDate.parse(dateInput, formatter); 

        Invoice invoice = new Invoice(client, date);

        while (!create) {
    
            productService.getAllProducts();
            id = 0;

            do {
                System.out.println("Select product:");
                id = sc.nextInt();
            } while (id < 1);

            Product product = productService.findProductById(id);
            if (product == null) {
                System.out.println("There's no product with that id");
                return;
            }

            int quantity = 0;
            do {
                System.out.println("Quantity:");
                id = sc.nextInt();
            } while (quantity < 1);

            InvoiceLine invoiceLine = new InvoiceLine(product, quantity);
            invoice.addLine(invoiceLine);

            System.out.println("Add another product? (1 = yes, 0 = no)");
            int option = sc.nextInt();

            if (option == 0) {
                create = true;
            }

        }

        invoiceService.createInvoice(invoice);
    }
}
