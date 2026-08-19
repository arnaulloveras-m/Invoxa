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

            case 4:
                editClient();
                break;

            case 5:
                deleteClient();
                break;     
                    
            default:
                System.out.println("Invalid number");
                break;
        }
        
    }

    private void createClient() {
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

    private void getAllClients() {
        ArrayList<Client> clients = clientService.getAllClients();
    
        for (Client client: clients) {
            System.out.println(client);
        }
    }

    private void findClientById() {
        int id;
        do {
            System.out.println("What id you want to search: ");
            id = sc.nextInt();
        } while (id < 1);

        Client client = clientService.findClientById(id);

        if (client == null) {
            System.out.println("There's no client with that id");
        } else {
            System.out.println(client);
        }
    }

    private void editClient() {
        getAllClients();
        
        int id;
        do {
            System.out.println("What id you want to edit: ");
            id = sc.nextInt();
        } while (id < 1);

        Client client = clientService.findClientById(id);
        if (client == null) {
            System.out.println("There's no client with that id");
            return;
        }

        int parameter;
        System.out.println("[1].Name");
        System.out.println("[2].NIF");
        System.out.println("[3].Email");
        System.out.println("[4].Phone");
        System.out.println("[5].Address");
        do {
            System.out.println("What parameter you want to change: ");
            parameter = sc.nextInt();
            sc.nextLine(); //Consuming last scanner
        } while (parameter < 1 || parameter > 5);

        switch (parameter) {
            case 1:
                System.out.println("Actual name: " + client.getName());
                System.out.println("New name: " );
                String newName = sc.nextLine();
                client.setName(newName);
                break;

            case 2:
                System.out.println("Actual NIF: " + client.getNif());
                System.out.println("New NIF: " );
                String newNIF = sc.nextLine();
                client.setNif(newNIF);
                break;

            case 3:
                System.out.println("Actual email: " + client.getEmail());
                System.out.println("New email: " );
                String newEmail = sc.nextLine();
                client.setEmail(newEmail);
                break;

            case 4:
                System.out.println("Actual phone: " + client.getPhone());
                System.out.println("New phone: " );
                String newPhone = sc.nextLine();
                client.setPhone(newPhone);
                break; 

            case 5:
                System.out.println("Actual address: " + client.getAddress());
                System.out.println("New address: " );
                String newAddress = sc.nextLine();
                client.setAddress(newAddress);
                break;         
        
            default:
                break;
        }
    }

    private void deleteClient() {
        getAllClients();
        
        int id;
        do {
            System.out.println("What id you want to delete: ");
            id = sc.nextInt();
        } while (id < 1);

        if (clientService.deleteClient(id)) {
            System.out.println("Client deleted successfully.");
        } else {
            System.out.println("That client doesn't exist.");
        }
    }
}
