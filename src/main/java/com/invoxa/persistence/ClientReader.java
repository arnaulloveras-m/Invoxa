package src.main.java.com.invoxa.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import src.main.java.com.invoxa.model.Client;


public class ClientReader {
    
    private ArrayList<Client> clients = new ArrayList<Client>();

    public ArrayList<Client> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/clients.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String id = data[0];
                int idInt = Integer.parseInt(id);
                String name = data[1];
                String nif = data[2];
                String email = data[3];
                String phone = data[4];
                String address = data[5];

                Client.updateNextId(idInt);
                var client = new Client(idInt, name, nif, email, phone, address);
                clients.add(client);
            }
        } catch (IOException e) {
          System.out.println("Error reading file.");
        }

        return clients;
    }

    public ArrayList<Client> getClients() {
        return new ArrayList<>(clients);
    }
}
