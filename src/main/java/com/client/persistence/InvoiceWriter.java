package src.main.java.com.client.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import src.main.java.com.client.model.Invoice;
import src.main.java.com.client.model.InvoiceLine;

public class InvoiceWriter {
    
    public void writeFile(ArrayList<Invoice> invoices) {
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/invoices.txt"))) {

            for (Invoice invoice : invoices) {
                bw.write(
                    invoice.getId() + ";" +
                    invoice.getClient().getId() + ";" +
                    invoice.getDate() + ";"
                );

                ArrayList<InvoiceLine> lines = invoice.getLines();

                for (int i = 0; i < lines.size(); i++) {

                    InvoiceLine line = lines.get(i);

                    bw.write(
                        line.getProductId() + "," +
                        line.getProductName() + "," +
                        line.getQuantity() + "," +
                        line.getUnitPrice() + "," +
                        line.getTax()
                    );

                    if (i < lines.size() - 1) {
                        bw.write("|");
                    }
                }

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing file." + e);
        }
    }
}
