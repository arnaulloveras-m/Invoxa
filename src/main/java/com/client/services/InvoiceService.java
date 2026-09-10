package src.main.java.com.client.services;

import java.util.ArrayList;

import src.main.java.com.client.model.Invoice;
import src.main.java.com.client.persistence.InvoiceReader;
import src.main.java.com.client.persistence.InvoiceWriter;

public class InvoiceService {

    private ArrayList<Invoice> invoicesList;
    private InvoiceReader invoiceReader;
    private InvoiceWriter invoiceWriter;

    public void createInvoice(Invoice invoice) {
        invoicesList.add(invoice);
        //saveInvoices()
    }
    
}
