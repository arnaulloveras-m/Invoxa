package src.main.java.com.invoxa.services;

import src.main.java.com.invoxa.model.Client;
import src.main.java.com.invoxa.persistence.ClientReader;
import src.main.java.com.invoxa.persistence.ClientWriter;

import java.util.ArrayList;

public class ClientService {

    private ArrayList<Client> clientsList = new ArrayList<>();
    private ClientReader clientReader;
    private ClientWriter clientWriter;

    public ClientService() {
        clientReader = new ClientReader();
        clientsList = clientReader.readFile();
        clientWriter = new ClientWriter();
    }

    public void createClient(String name, String nif, String email, String phone, String address) {
        var client = new Client(name, nif, email, phone, address);
        clientsList.add(client);
        clientWriter.writeFile(clientsList);
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

    public void saveClients() {
        clientWriter.writeFile(clientsList);
    }

    public boolean deleteClient(int id) {
        Client client = findClientById(id);

        if (client != null) {
            clientsList.remove(client);
            saveClients();
            return true;
        } 
        
        return false;
    }
}
