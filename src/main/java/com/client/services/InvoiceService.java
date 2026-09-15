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

    public InvoiceService() {
        invoicesList = new ArrayList<>();
    }

    public void createInvoice(Invoice invoice) {
        invoicesList.add(invoice);
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

    public boolean deleteInvoice(int id) {
        Invoice invoice = findInvoiceById(id);

        if (invoice != null) {
            invoicesList.remove(invoice);
            return true;
        } 
        
        return false;
    }
    
}
