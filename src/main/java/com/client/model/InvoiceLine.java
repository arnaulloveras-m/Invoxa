package src.main.java.com.client.model;
import java.math.BigDecimal;

public class InvoiceLine {

    private Product product;
    private int quantity;
    private BigDecimal unitPrice;

    public InvoiceLine(Product product, int quantity, BigDecimal unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
    }

    @Override
    public String toString() {
        return product.getName() + " x" + quantity + " | " + product.getPrice() + " €/ud | Total: " + getTotal() + " €";
    }

    public BigDecimal getTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}