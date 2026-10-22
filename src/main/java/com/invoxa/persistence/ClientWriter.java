package src.main.java.com.invoxa.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import src.main.java.com.invoxa.model.Client;

public class ClientWriter {

    public void writeFile(ArrayList<Client> clients) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/clients.txt"))) {

            for (Client client : clients) {
                bw.write(
                    client.getId() + ";" +
                    client.getName() + ";" +
                    client.getNif() + ";" +
                    client.getEmail() + ";" +
                    client.getPhone() + ";" + 
                    client.getAddress() + ";" + 
                    client.getCreatedAt()
                );
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing file." + e);
        }
    
    }
}
