package src.main.java.com.client.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.main.java.com.client.model.Client;
import src.main.java.com.client.services.ClientService;

public class ClientMenu {

    private Scanner sc = new Scanner(System.in);
    private int option = -1;
    private ClientService clientService = new ClientService();
    
    public void clientMenu() {
        System.out.println("====== CLIENTS ======");
        System.out.println("1.Create client");
        System.out.println("2.List clients");
        System.out.println("3.Find client by ID");
        System.out.println("4.Edit client");
        System.out.println("5.Delete client");
        System.out.println("6.View client's invoices");
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
                createClient();
                break;

            case 2:
                getAllClients();
                break;
        
            case 3:
                findClientById();
                break;
                    
            default:
                System.out.println("Invalid number");
                break;
        }
        
    }

    public void createClient() {
        sc.nextLine(); //Consuming the last nextInt()
        System.out.println("What is client's name: ");
        String name = sc.nextLine();
        if (name.isBlank()) {
            System.out.println("Name cannot be null or blank: ");
            name = sc.nextLine();
        } 
        
        System.out.println("What is client's NIF: ");
        String nif = sc.nextLine();
        if (nif.isBlank()) {
            System.out.println("NIF cannot be null or blank: ");
            nif = sc.nextLine();
        } 
        
        System.out.println("What is client's mail: ");
        String mail = sc.nextLine();
        if (mail.isBlank()) {
            System.out.println("Mail cannot be null or blank: ");
            mail = sc.nextLine();
        }

        System.out.println("What is client's phone: ");
        String phone = sc.nextLine();
        if (phone.isBlank()) {
            System.out.println("Phone cannot be null or blank: ");
            phone = sc.nextLine();
        } 

        System.out.println("What is client's address: ");
        String address = sc.nextLine();
        if (address.isBlank()) {
            System.out.println("Address cannot be null or blank: ");
            address = sc.nextLine();
        } 
        
        clientService.createClient(name, nif, mail, phone, address);
    }

    public void getAllClients() {
        ArrayList<Client> clients = clientService.getAllClients();
    
        for (Client client: clients) {
            System.out.println(client);
        }
    }

    public void findClientById() {
        int id;
        do {
            System.out.println("Que id quieres buscar: ");
            id = sc.nextInt();
        } while (id < 1);

        Client client = clientService.findClientById(id);

        if (client == null) {
            System.out.println("NO hay cliente con ese id");
        } else {
            System.out.println(client);
        }
    }
}
