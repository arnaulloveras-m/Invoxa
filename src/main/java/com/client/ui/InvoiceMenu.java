package src.main.java.com.client.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    private ClientService clientService;
    private ProductService productService;
    private InvoiceService invoiceService;

    public InvoiceMenu(
            ClientService clientService,
            ProductService productService,
            InvoiceService invoiceService) {

        this.clientService = clientService;
        this.productService = productService;
        this.invoiceService = invoiceService;
}
    
    private Scanner sc = new Scanner(System.in);
    private int option = -1;
        
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
                createInvoice();
                break;

            case 2:
                getAllInvoices();
                break;
        
            case 3:
                findInvoiceById();
                break;

            case 4:
                deleteInvoice();
                break;  
                    
            default:
                System.out.println("Invalid number");
                break;
        }
        
    }

    private void createInvoice() {
        boolean addAnother = false;

        ArrayList<Client> clients = clientService.getAllClients();

        for (Client client : clients) {
            System.out.println(client);
        }
        
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

        sc.nextLine(); //Consume the entrance of scanner

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Date(dd/MM/yyyy): ");
        String dateInput = sc.nextLine();

        LocalDate date = LocalDate.parse(dateInput, formatter); 

        Invoice invoice = new Invoice(client, date);

        while (!addAnother) {
    
            productService.getAllProducts();
            id = 0;

            do {
                System.out.println("Select product:");
                id = sc.nextInt();
                sc.nextLine(); //Consume the scanner entrance
            } while (id < 1);

            Product product = productService.findProductById(id);
            if (product == null) {
                System.out.println("There's no product with that id");
                return;
            }

            int quantity = 0;
            do {
                System.out.println("Quantity:");
                quantity = sc.nextInt();
            } while (quantity < 1);

            InvoiceLine invoiceLine = new InvoiceLine(product, quantity);
            invoice.addLine(invoiceLine);

            System.out.println("Add another product? (1 = yes, 0 = no)");
            int option = sc.nextInt();

            if (option == 0) {
                addAnother = true;
            }

        }

        invoiceService.createInvoice(invoice);
    }

    private void getAllInvoices() {
        ArrayList<Invoice> invoices = invoiceService.getAllInvoices();
    
        for (Invoice invoice: invoices) {
            System.out.println(invoice);
        }
    }

    private void findInvoiceById() {
        int id;
        do {
            System.out.println("What id you want to search: ");
            id = sc.nextInt();
        } while (id < 1);

        Invoice invoice = invoiceService.findInvoiceById(id);

        if (invoice == null) {
            System.out.println("There's no invoice with that id");
        } else {
            System.out.println(invoice);
        }
    }

    private void deleteInvoice() {
        getAllInvoices();
        
        int id;
        do {
            System.out.println("What id you want to delete: ");
            id = sc.nextInt();
        } while (id < 1);

        if (invoiceService.deleteInvoice(id)) {
            System.out.println("Invoice deleted successfully.");
        } else {
            System.out.println("That invoice doesn't exist.");
        }
    }
}
