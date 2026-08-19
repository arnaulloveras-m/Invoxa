package src.main.java.com.client.services;

import src.main.java.com.client.model.Client;
import java.util.ArrayList;

public class ClientService {

    private ArrayList<Client> clientsList = new ArrayList<>();
    

    public void createClient(String name, String nif, String email, String phone, String address) {
        var client = new Client(name, nif, email, phone, address);
        clientsList.add(client);
    }

    public ArrayList<Client> getAllClients() {
        return new ArrayList<>(clientsList);
    }

    public Client findClientById(int id) {
    
        for (Client client: clientsList) {
            if(client.getId() == id) {
                return client;
            }
        } 

        return null;
    }

    public boolean deleteClient(int id) {
        Client client = findClientById(id);

        if (client != null) {
            clientsList.remove(client);
            return true;
        } 
        
        return false;
    }
}
