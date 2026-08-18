package src.main.java.com.client.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {

    private static int nextId = 1;

    private int id;
    private Client client;
    private LocalDate date;
    private ArrayList<InvoiceLine> lines;    

    public Invoice(Client client, LocalDate date) {
        this.id = nextId++;
        this.client = client;
        this.setDate(date);
        this.lines = new ArrayList<>();
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Invoice date cannot be null");
        }
        
        if (date.getYear() != LocalDate.now().getYear()) {
            throw new IllegalArgumentException("The years date cannot be last or next year");
        }

        this.date = date;
    }

    public void addLine(InvoiceLine line) {
        lines.add(line);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
    
        for(InvoiceLine line : lines) {
            total = total.add(line.getTotal());
        }

        return total;
    }


}