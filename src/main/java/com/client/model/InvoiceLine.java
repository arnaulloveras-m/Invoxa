package src.main.java.com.client.model;
import java.math.BigDecimal;

public class InvoiceLine {

    private int productId;
    private String productName;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal tax;

    public InvoiceLine(Product product, int quantity) {
        this.productId = product.getId();
        this.productName = product.getName();
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
        this.tax = product.getTax();
    }

    public InvoiceLine(int productId, String productName, int quantity, BigDecimal unitPrice, BigDecimal tax) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.tax = tax;
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


    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public BigDecimal getTax() {
        return tax;
    }

}