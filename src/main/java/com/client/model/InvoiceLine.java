package src.main.java.com.client.model;
import java.math.BigDecimal;

public class InvoiceLine {

    private Product product;
    private String productName;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal tax;

    public InvoiceLine(Product product, int quantity) {
        this.productName = product.getName();
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
        this.tax = product.getTax();
    }

    @Override
    public String toString() {
        return productName + " x" + quantity
                + " | " + unitPrice + " €/ud"
                + " | Total: " + getTotal() + " €";
    }

    public BigDecimal getTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}