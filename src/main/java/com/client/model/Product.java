package src.main.java.com.client.model;

import java.math.BigDecimal;

public class Product {

    private static int nextId = 1;

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal tax;

    public Product(int id, String name, String description, BigDecimal price, BigDecimal tax) {
        this.id = id;
        updateNextId(id);
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setTax(tax);
    }

    public Product(String name, String description, BigDecimal price, BigDecimal tax) {
        this.id = nextId++;
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setTax(tax);
    }

    public static void updateNextId(int id) {
        if (id >= nextId) {
            nextId = id + 1;
        }
    }

    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name + "', description='" + description + "', price='" + price + "', tax='" + tax +"}";
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be null or negative");
        }

        this.price = price;
    }

    public void setTax(BigDecimal tax) {
        if (tax == null || tax.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Tax cannot be null or negative");
        }

        this.tax = tax;
    }
    
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTax() {
        return this.tax;
    }

}