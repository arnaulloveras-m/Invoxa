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

    public Invoice(int id, Client client, LocalDate date, ArrayList<InvoiceLine> lines) {
        this.id = id;
        this.client = client;
        this.setDate(date);
        this.lines = lines;

        updateNextId(id);
    }

    public static void updateNextId(int id) {
        if (id >= nextId) {
            nextId = id + 1;
        }
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Invoice date cannot be null");
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

    public int getId() {
        return this.id;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<InvoiceLine> getLines() {
        return new ArrayList<>(lines);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("===== INVOICE #")
            .append(id)
            .append(" =====\n");

        result.append("Client: ")
            .append(client)
            .append("\n");

        result.append("Date: ")
            .append(date)
            .append("\n");

        result.append("Products:\n");

        for (InvoiceLine line : lines) {
            result.append("  ")
                .append(line)
                .append("\n");
        }

        result.append("TOTAL: ")
            .append(getTotal())
            .append(" €");

        return result.toString();
    }


}