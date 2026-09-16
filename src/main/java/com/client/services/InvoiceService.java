package src.main.java.com.client.services;

import java.util.ArrayList;

import src.main.java.com.client.model.Client;
import src.main.java.com.client.model.Invoice;
import src.main.java.com.client.persistence.InvoiceReader;
import src.main.java.com.client.persistence.InvoiceWriter;

public class InvoiceService {

    private ArrayList<Invoice> invoicesList;
    private InvoiceReader invoiceReader;
    private InvoiceWriter invoiceWriter;

    public InvoiceService(ClientService clientService) {
        invoiceReader = new InvoiceReader(clientService);
        invoicesList = invoiceReader.readFile();
        invoiceWriter = new InvoiceWriter();
    }

    public void createInvoice(Invoice invoice) {
        invoicesList.add(invoice);
        invoiceWriter.writeFile(invoicesList);
        //saveInvoices()
    }

    public ArrayList<Invoice> getAllInvoices() {
        return new ArrayList<>(invoicesList);
    }

    public Invoice findInvoiceById(int id) {
    
        for (Invoice invoice: invoicesList) {
            if(invoice.getId() == id) {
                return invoice;
            }
        } 

        return null;
    }

    public void saveInvoices() {
        invoiceWriter.writeFile(invoicesList);
    }

    public boolean deleteInvoice(int id) {
        Invoice invoice = findInvoiceById(id);

        if (invoice != null) {
            invoicesList.remove(invoice);
            saveInvoices();
            return true;
        } 
        
        return false;
    }
    
}
