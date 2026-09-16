package src.main.java.com.client.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import src.main.java.com.client.model.Invoice;
import src.main.java.com.client.model.InvoiceLine;
import src.main.java.com.client.services.ClientService;
import src.main.java.com.client.model.Client;

public class InvoiceReader {
    
    private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    private  ClientService clientService = new ClientService();
    public InvoiceReader(ClientService clientService) {
        this.clientService = clientService;
    }
    
    public ArrayList<Invoice> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/invoices.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
               String[] data = line.split(";");

            int idInt = Integer.parseInt(data[0]);

            int clientId = Integer.parseInt(data[1]);
            Client client = clientService.findClientById(clientId);

            LocalDate date = LocalDate.parse(data[2]);

            String[] linesData = data[3].split("\\|");
            ArrayList<InvoiceLine> lines = new ArrayList<>();

            for (String lineData : linesData) {

                String[] lineFields = lineData.split(",");

                int productId = Integer.parseInt(lineFields[0]);
                String productName = lineFields[1];
                int quantity = Integer.parseInt(lineFields[2]);
                BigDecimal unitPrice = new BigDecimal(lineFields[3]);
                BigDecimal tax = new BigDecimal(lineFields[4]);

                InvoiceLine invoiceLine = new InvoiceLine(
                        productId,
                        productName,
                        quantity,
                        unitPrice,
                        tax
                );

                lines.add(invoiceLine);
            }

            Invoice.updateNextId(idInt);

            Invoice invoice = new Invoice(
                    idInt,
                    client,
                    date,
                    lines
            );

            invoices.add(invoice);
        }
        } catch (IOException e) {
          System.out.println("Error reading file.");
        }

        return invoices;
    }

    public ArrayList<Invoice> getInvoices() {
        return new ArrayList<>(invoices);
    }
}
